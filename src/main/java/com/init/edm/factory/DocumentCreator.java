package com.init.edm.factory;

import jakarta.xml.bind.JAXBException;
import com.init.edm.model.entity.document.Document;

import java.io.IOException;

/**
 * Предоставляет метод создания документа.
 *
 * @author GKordyukova
 */
public interface DocumentCreator {

    /**
     * Создать документ
     *
     * @return {@link Document}
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     * @throws IOException   исключение ввода-вывода
     */
    Document create() throws JAXBException, IOException;
}
