package com.init.edm.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс создания таблицы "Сотрудники".
 *
 * @author GKordyukova
 */
@Component
public class PersonTableCreator implements StaffTableCreator {

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Запрос по созданию таблицы Сотрудников
     */
    private final String CREATE_TABLE_PERSONS_QUERY = "CREATE TABLE Persons (uuid varchar(255), surname varchar(255) NOT NULL," +
            "name varchar(255) NOT NULL, patronymic varchar(255), position varchar(255), dateOfBirth Date NOT NULL, telephone varchar(128) NOT NULL, photo varchar(128))";

    /**
     * Создать таблицу "Сотрудники".
     *
     * @param tableName название таблицы
     */
    @Override
    public void createTable(String tableName) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_PERSONS_QUERY)) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, null);
            if (!resultSet.next()) {
                preparedStatement.execute();
            }
            resultSet.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new RuntimeException("Ошибка соединения с базой данных");
        }
    }
}
