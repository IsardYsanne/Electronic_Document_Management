package com.init.edm.model.entity.staff;

import java.util.List;

/**
 * Описывает характеристики организации.
 *
 * @author GKordyukova
 */
public class OrganizationStaff extends Staff {

    /**
     * Полное наименование подразделения
     */
    private String fullOrganizationName;

    /**
     * Краткое наименование подразделения
     */
    private String shortOrganizationName;

    /**
     * Руководитель подразделения
     */
    private PersonStaff director;

    /**
     * Контактные телефоны
     */
    private List<String> organizationPhones;

    public String getFullOrganizationName() {
        return fullOrganizationName;
    }

    public void setFullOrganizationName(String fullOrganizationName) {
        this.fullOrganizationName = fullOrganizationName;
    }

    public String getShortOrganizationName() {
        return shortOrganizationName;
    }

    public void setShortOrganizationName(String shortOrganizationName) {
        this.shortOrganizationName = shortOrganizationName;
    }

    public PersonStaff getDirector() {
        return director;
    }

    public void setDirector(PersonStaff director) {
        this.director = director;
    }

    public List<String> getOrganizationPhones() {
        return organizationPhones;
    }

    public void setOrganizationPhones(List<String> organizationPhones) {
        this.organizationPhones = organizationPhones;
    }
}
