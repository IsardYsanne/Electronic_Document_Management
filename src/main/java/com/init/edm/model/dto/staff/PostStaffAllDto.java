package com.init.edm.model.dto.staff;

import java.util.UUID;

/**
 * Служит для отображения всех полей должности на UI.
 *
 * @author GKordyukova
 */
public class PostStaffAllDto {

    /**
     * Идентификатор должности
     */
    private UUID id;

    /**
     * Название должности
     */
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
