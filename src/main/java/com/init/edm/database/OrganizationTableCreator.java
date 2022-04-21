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
 * Класс создания таблицы "Организация".
 *
 * @author GKordyukova
 */
@Component
public class OrganizationTableCreator implements StaffTableCreator {

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Запрос по созданию таблицы Организации.
     */
    private final String CREATE_TABLE_ORGANIZATION_QUERY = "CREATE TABLE Organizations (uuid varchar(255), fullName varchar(255) NOT NULL," +
            "shortName varchar(128) NOT NULL, director varchar(255), phones varchar(128) NOT NULL)";

    /**
     * Создать таблицу "Организация".
     *
     * @param tableName название таблицы
     */
    @Override
    public void createTable(String tableName) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_ORGANIZATION_QUERY)) {
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
