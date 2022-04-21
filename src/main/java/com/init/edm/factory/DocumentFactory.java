package com.init.edm.factory;

import com.init.edm.storage.document.DocumentNamesStorage;
import com.init.edm.storage.document.RegistrationNumbersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import com.init.edm.repository.staff.interfaces.PersonsStaffRepository;
import com.init.edm.model.entity.document.Document;
import com.init.edm.utilities.DateCreator;
import com.init.edm.utilities.Randomizer;

import java.util.UUID;

/**
 * Использует фабрику для случайного заполнения документов.
 *
 * @author GKordyukova
 */
public abstract class DocumentFactory implements DocumentCreator {

    /**
     * Генератор случайных чисел
     */
    @Autowired
    protected Randomizer randomizer;

    /**
     * Хранилище названий документов
     */
    @Autowired
    protected DocumentNamesStorage documentNamesStorage;

    /**
     * Хранилище регистрационных номеров
     */
    @Autowired
    protected RegistrationNumbersStorage registrationNumbersStorage;

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    protected PersonsStaffRepository personsStaffRepository;

    /**
     * Обработчик даты
     */
    @Autowired
    protected DateCreator dateCreator;

    /**
     * Сгенерировать случайные значения полей для документа.
     *
     * @param document документ, поля которого заполняем случайными значениями
     */
    public void generateDocumentFields(Document document) {
        Integer registrationNumber = randomizer.getRandomNumberBetween(1, 30000);
        document.setId(UUID.randomUUID());
        document.setName(randomizer.getRandomDocumentField(documentNamesStorage.getDocumentNameList()));
        document.setText("Содержимое документа");
        document.setRegNumber(registrationNumber);
        document.setDate(dateCreator.createDate());
        document.setAuthor(randomizer.getRandomDocumentField(personsStaffRepository.findAll()));
        registrationNumbersStorage.getNumbers().add(registrationNumber);
    }
}