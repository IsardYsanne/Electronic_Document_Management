package com.init.edm.repository.staff.filler.interfaces;

import jakarta.xml.bind.JAXBException;

import java.sql.SQLException;

/**
 * Предоставляет метод для заполнения репозитория должностей.
 *
 * @author GKordyukova
 */
public interface PostStaffRepositoryFiller {

    /**
     * Заполнить репозиторий должностей данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    void fillPostStaffRepository(String fileName) throws JAXBException, SQLException;
}
