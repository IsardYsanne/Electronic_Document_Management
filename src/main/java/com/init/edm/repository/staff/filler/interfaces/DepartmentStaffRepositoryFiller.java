package com.init.edm.repository.staff.filler.interfaces;

import jakarta.xml.bind.JAXBException;

/**
 * Предоставляет метод для заполнения репозитория подразделений.
 *
 * @author GKordyukova
 */
public interface DepartmentStaffRepositoryFiller {

    /**
     * Заполнить репозиторий подразделений данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    void fillDepartmentStaffRepository(String fileName) throws JAXBException;
}
