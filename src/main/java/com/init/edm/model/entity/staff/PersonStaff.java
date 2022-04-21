package com.init.edm.model.entity.staff;

import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.init.edm.jaxb.DateTimeAdapter;
import com.init.edm.photo.FileXmlHandler;

import java.io.File;
import java.text.MessageFormat;
import java.sql.Date;

/**
 * Описывает сотрудника организации.
 *
 * @author GKordyukova
 */
public class PersonStaff extends Staff implements Comparable<PersonStaff> {

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

    /**
     * Аватар сотрудника
     */
    private File photo;

    /**
     * Сортировать сотрудников в лексикографическом порядке
     *
     * @param o объект для сравнения с данным экземпляром
     * @return int
     */
    @Override
    public int compareTo(PersonStaff o) {
        return getSurname().compareTo(o.getSurname());
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public PostStaff getPosition() {
        return position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPosition(PostStaff position) {
        this.position = position;
    }

    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public File getPhoto() {
        return photo;
    }

    @XmlJavaTypeAdapter(FileXmlHandler.class)
    public void setPhoto(File photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        MessageFormat messageFormat = new MessageFormat("{0} {1} {2}");
        Object[] format = {getSurname(), getName(), getPatronymic()};
        return messageFormat.format(format);
    }

    /**
     * Сравнить части двух объектов Person, которые должны быть равны, для того чтобы два объекта считались «равными»
     *
     * @param obj объект для сравнения
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonStaff that = (PersonStaff) obj;
        return surname.equals(that.surname) &&
               name.equals(that.name) &&
               patronymic.equals(that.patronymic) &&
               position.equals(that.position) &&
               dateOfBirth.equals(that.dateOfBirth) &&
               telephone.equals(that.telephone);
    }
}
