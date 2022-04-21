package com.init.edm.storage.document;

import org.springframework.stereotype.Component;
import com.init.edm.model.entity.document.Document;

import java.util.List;

/**
 * Класс для работы с коллекцией документов.
 *
 * @author GKordyukova
 */
@Component
public class DocumentsStorageImpl implements DocumentsStorage{

    /**
     * Список документов
     */
    private List<Document> documents;

    /**
     * Получить коллекцию документов
     *
     * @return List {@link Document} список документов
     */
    @Override
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Задать коллекцию документов
     *
     * @param documents список документов
     */
    @Override
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
