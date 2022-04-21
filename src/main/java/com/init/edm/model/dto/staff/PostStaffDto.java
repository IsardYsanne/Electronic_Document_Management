package com.init.edm.model.dto.staff;

/**
 * Служит для отображения поля "название должности" на UI.
 *
 * @author GKordyukova
 */
public class PostStaffDto {

    /**
     * Название должности
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
