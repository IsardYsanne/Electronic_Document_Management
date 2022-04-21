package com.init.edm.model.entity.staff;

import com.init.edm.utilities.Storable;

/**
 * Описывает должность сотрудника.
 *
 * @author GKordyukova
 */
public class PostStaff extends Staff implements Storable {

    /**
     * Название должности
     */
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
