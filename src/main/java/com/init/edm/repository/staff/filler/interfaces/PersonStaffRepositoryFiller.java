package com.init.edm.repository.staff.filler.interfaces;

import jakarta.xml.bind.JAXBException;

import java.sql.SQLException;

/**
 * Предоставляет метод для заполнения репозитория сотрудников.
 *
 * @author GKordyukova
 */
public interface PersonStaffRepositoryFiller {

    /**
     * Заполнить репозиторий сотрудников данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    void fillPersonStaffRepository(String fileName) throws JAXBException, SQLException;
}
