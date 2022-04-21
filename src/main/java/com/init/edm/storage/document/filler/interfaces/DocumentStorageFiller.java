package com.init.edm.storage.document.filler.interfaces;

/**
 * Предоставляет метод для заполнения хранилища документов.
 *
 * @author GKordyukova
 */
public interface DocumentStorageFiller {

    /**
     * Заполнить хранилище документов коллекцей документов.
     *
     * @param documentCount рандомное количество докуметов
     */
    void fillDocumentStorage(int documentCount);
}
