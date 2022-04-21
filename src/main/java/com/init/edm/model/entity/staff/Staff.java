package com.init.edm.model.entity.staff;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;

import java.util.UUID;

/**
 * Абстрактный класс, представляющий собой элемент организационной структуры.
 *
 * @author GKordyukova
 */
@XmlType(name = "staff")
@XmlSeeAlso({PostStaff.class, DepartmentStaff.class, OrganizationStaff.class, PersonStaff.class})
public abstract class Staff {

    /**
     * Идентификатор элеменета организационной структуры
     */
    private UUID uuid;

    @XmlAttribute
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
