package com.init.edm.storage.document.filler.implementations;

import com.init.edm.storage.document.DocumentsStorageImpl;
import com.init.edm.storage.document.filler.interfaces.DocumentStorageFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.init.edm.service.document.DocumentService;

/**
 * Класс для заполнения хранилища документов.
 *
 * @author GKordyukova
 */
@Component
public class DocumentStorageFillerImpl implements DocumentStorageFiller {

    /**
     * Хранилище документов
     */
    @Autowired
    private DocumentsStorageImpl documentsStorage;

    /**
     * Сервис документов
     */
    @Autowired
    private DocumentService documentService;

    /**
     * Заполнить репозиторий документов коллекцей документов.
     *
     * @param documentCount рандомное количество докуметов
     */
    @Override
    public void fillDocumentStorage(int documentCount) {
        documentsStorage.setDocuments(documentService.generateDocumentsCollection(documentCount));
    }
}
