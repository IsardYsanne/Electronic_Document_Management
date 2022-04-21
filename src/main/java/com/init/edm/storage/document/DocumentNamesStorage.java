package com.init.edm.storage.document;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Класс для работы с коллекцией названий документов.
 *
 * @author GKordyukova
 */
@Component
public class DocumentNamesStorage {

    /**
     * Список названий документов
     */
    private List<String> namesOfDocument;

    /**
     * Заполнить коллекцию названий документов.
     *
     * @return List {@link String} список названий
     */
    public List<String> getDocumentNameList() {
        namesOfDocument = Arrays.asList("Certificate of Completion", "Contract", "Test", "Task", "Instructions");
        return namesOfDocument;
    }
}
