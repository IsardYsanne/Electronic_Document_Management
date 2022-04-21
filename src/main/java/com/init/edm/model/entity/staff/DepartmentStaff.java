package com.init.edm.model.entity.staff;

import java.util.List;

/**
 * Описывает характеристики подразделения.
 *
 * @author GKordyukova
 */
public class DepartmentStaff extends Staff {

    /**
     * Полное наименование подразделения
     */
    private String fullDepartmentName;

    /**
     * Краткое наименование подразделения
     */
    private String shortDepartmentName;

    /**
     * Руководитель подразделения
     */
    private PersonStaff manager;

    /**
     * Контактные телефоны
     */
    private List<String> departmentPhones;
    
    public String getFullDepartmentName() {
        return fullDepartmentName;
    }

    public void setFullDepartmentName(String fullDepartmentName) {
        this.fullDepartmentName = fullDepartmentName;
    }

    public String getShortDepartmentName() {
        return shortDepartmentName;
    }

    public void setShortDepartmentName(String shortDepartmentName) {
        this.shortDepartmentName = shortDepartmentName;
    }

    public PersonStaff getManager() {
        return manager;
    }

    public void setManager(PersonStaff manager) {
        this.manager = manager;
    }

    public List<String> getDepartmentPhones() {
        return departmentPhones;
    }

    public void setDepartmentPhones(List<String> departmentPhones) {
        this.departmentPhones = departmentPhones;
    }
}
