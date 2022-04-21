package com.init.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.init.edm.model.dto.document.DocumentDto;
import com.init.edm.model.entity.document.Document;
import com.init.edm.service.document.DocumentService;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер по работе с документами.
 *
 * @author GKordyukova
 */
@RestController
@RequestMapping("ecm/document")
public class DocumentController {

    /**
     * Сервис документов
     */
    @Autowired
    private DocumentService documentService;

    /**
     * Вывести документы, созданные автором.
     *
     * @param authorId идентификатор автора документа
     * @return List {@link Document} список документов
     */
    @GetMapping("/author/{authorId}")
    public List<Document> getDocumentsByAuthorId(@PathVariable String authorId) {
        return  documentService.findAllByAuthorId(UUID.fromString(authorId));
    }

    /**
     * Найти документ по идентификатору.
     *
     * @param id идентификатор документа
     * @return {@link DocumentDto} дто документа
     */
    @GetMapping("/{id}")
    public DocumentDto findById(@PathVariable String id) {
        return documentService.findById(UUID.fromString(id));
    }

    /**
     * Найти все документы.
     *
     * @return List {@link DocumentDto} список документов
     */
    @GetMapping("")
    public List<DocumentDto> findAll() {
        return documentService.findAll();
    }
}
