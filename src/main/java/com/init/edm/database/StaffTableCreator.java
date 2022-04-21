package com.init.edm.database;

/**
 * Интерфейс для создания таблиц оргштатных единиц.
 *
 * @author GKordyukova
 */
public interface StaffTableCreator {

    /**
     * Создать таблицу для оргштатной единицы
     *
     * @param tableName название таблицы
     */
    void createTable(String tableName);
}
