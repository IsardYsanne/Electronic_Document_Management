package com.init.edm.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Создает таблицы для оргштатных единиц
 *
 * @author GKordyukova
 */
@Component
public class StaffTableCreatorInitializer {

    /**
     * Создание таблицы "Сотрудники"
     */
    @Autowired
    private StaffTableCreator personTableCreator;

    /**
     * Создание таблицы "Подразделение"
     */
    @Autowired
    private StaffTableCreator departmentTableCreator;

    /**
     * Создание таблицы "Организация"
     */
    @Autowired
    private StaffTableCreator organizationTableCreator;

    /**
     * Создание таблицы "Должность"
     */
    @Autowired
    private StaffTableCreator postTableCreator;

    /**
     * Создать таблицы с приведенными названиями.
     */
    public void createTablesStaff() {
        personTableCreator.createTable("Person");
        organizationTableCreator.createTable("Organization");
        departmentTableCreator.createTable("Department");
        postTableCreator.createTable("Posttable");
    }
}
