package com.init.edm.mapper.document.interfaces;

import com.init.edm.model.dto.document.DocumentDto;
import com.init.edm.model.entity.document.Document;

import java.util.List;

/**
 * Служит для конвертации сущности документа в DTO или наоборот.
 *
 * @author GKordyukova
 */
public interface DocumentMapper {

    /**
     * Конвертировать сущность документа в dto.
     *
     * @param document документ
     * @return {@link DocumentDto} Data Transfer Object документов
     */
    DocumentDto toDto(Document document);

    /**
     * Конвертировать список документов в dto.
     *
     * @param documents список документов
     * @return List {@link DocumentDto} сконвертированный список в необходимое нам представление
     */
    List<DocumentDto> toListDto(List<Document> documents);
}
