package com.init.edm.storage.document;

import com.init.edm.model.entity.document.Document;

import java.util.List;

/**
 * Хранилище документов.
 *
 * @author GKordyukova
 */
public interface DocumentsStorage {

    /**
     * Получить коллекцию документов
     *
     * @return List {@link Document} список документов
     */
    List<Document> getDocuments();

    /**
     * Задать коллекцию документов
     *
     * @param documents список документов
     */
    void setDocuments(List<Document> documents);
}
