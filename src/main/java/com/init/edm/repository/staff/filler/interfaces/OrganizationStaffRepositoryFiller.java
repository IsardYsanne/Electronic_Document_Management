package com.init.edm.repository.staff.filler.interfaces;

import jakarta.xml.bind.JAXBException;

/**
 * Предоставляет метод для заполнения репозитория организаций.
 *
 * @author GKordyukova
 */
public interface OrganizationStaffRepositoryFiller {

    /**
     * Заполнить репозиторий организаций данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    void fillOrganizationStaffRepository(String fileName) throws JAXBException;
}
