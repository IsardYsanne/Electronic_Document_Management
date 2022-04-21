package com.init.edm.model.dto.staff;

import com.init.edm.model.entity.staff.PostStaff;

import java.util.Date;
import java.util.UUID;

/**
 * Данные по сотруднику, которые отобразятся на UI, без фото.
 *
 * @author GKordyukova
 */
public class PersonStaffDto {

    /**
     * Идентификатор сотрудника
     */
    private UUID id;

    /**
     * Фамилия сотрудника
     */
    private String surname;

    /**
     * Имя сотрудника
     */
    private String name;

    /**
     * Отчество сотрудника
     */
    private String patronymic;

    /**
     * Должность сотрудника
     */
    private PostStaff position;

    /**
     * Дата рождения сотрудника
     */
    private Date dateOfBirth;

    /**
     * Телефонный номер сотрудника
     */
    private String telephone;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public PostStaff getPosition() {
        return position;
    }

    public void setPosition(PostStaff position) {
        this.position = position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
