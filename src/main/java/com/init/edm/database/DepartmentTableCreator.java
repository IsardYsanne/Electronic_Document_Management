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
 * Класс создания таблицы "Подразделение".
 *
 * @author GKordyukova
 */
@Component
public class DepartmentTableCreator implements StaffTableCreator {

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Запрос по созданию таблицы Подразделений
     */
    private final String CREATE_TABLE_DEPARTMENTS_QUERY = "CREATE TABLE Departments (uuid varchar(255), fullName varchar(255) NOT NULL," +
            "shortName varchar(128) NOT NULL, manager varchar(255), phones varchar(128) NOT NULL)";

    /**
     * Создать таблицу "Подразделение".
     *
     * @param tableName название таблицы
     */
    @Override
    public void createTable(String tableName) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_DEPARTMENTS_QUERY)) {
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
