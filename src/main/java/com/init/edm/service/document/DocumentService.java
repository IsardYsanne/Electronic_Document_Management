package com.init.edm.service.document;

import com.init.edm.model.dto.document.DocumentDto;
import com.init.edm.model.entity.document.Document;

import java.util.List;
import java.util.UUID;

/**
 * Предоставляет методы для сервиса документов.
 *
 * @author GKordyukova
 */
public interface DocumentService {

    /**
     * Создать и заполнить список документов.
     *
     * @param documentCount рандомное количество докуметов
     * @return List {@link Document} список документов
     */
    List<Document> generateDocumentsCollection(int documentCount);

    /**
     * Найти документ по идентификатору.
     *
     * @param uuid идентификатор документа
     * @return {@link DocumentDto} найденный документ
     */
    DocumentDto findById(UUID uuid);

    /**
     * Получить список документов, созданных автором.
     *
     * @param authorId идентификатор автора документа
     * @return List {@link Document} список документов
     */
    List<Document> findAllByAuthorId(UUID authorId);

    /**
     * Получить список документов.
     *
     * @return List {@link DocumentDto} dto списка документов
     */
    List<DocumentDto> findAll();
}
