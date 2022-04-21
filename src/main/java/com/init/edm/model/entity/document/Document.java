package com.init.edm.model.entity.document;

import com.init.edm.model.entity.staff.PersonStaff;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import com.init.edm.utilities.Storable;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Абстрактный класс Document, описывающий характеристики документа.
 *
 * @author GKordyukova
 */
@XmlType(name = "document")
@XmlSeeAlso({TaskDocument.class, IncomingDocument.class, OutgoingDocument.class})
abstract public class Document implements Comparable<Document>, Storable {

    /**
     * Идентификатор документа
     */
    private UUID id;

    /**
     * Название документа
     */
    private String name;

    /**
     * Текст документа
     */
    private String text;

    /**
     * Регистрационный номер документа
     */
    private Integer regNumber;

    /**
     * Дата регистрации документа
     */
    private LocalDate date;

    /**
     * Автор документа
     */
    private PersonStaff author;

    public Document() {
    }

    @Override
    public UUID getUuid() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Integer regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PersonStaff getAuthor() {
        return this.author;
    }

    public void setAuthor(PersonStaff author) {
        this.author = author;
    }

    /**
     * Сортировать документы по полям Регистрационный номер и Дата регистрации
     *
     * @param o объект для сравнения с данным экземпляром
     * @return int
     */
    @Override
    public int compareTo(Document o) {
        int result = this.date.compareTo(o.date);
        if (result == 0) result = this.regNumber - o.regNumber;
        return result;
    }
}
