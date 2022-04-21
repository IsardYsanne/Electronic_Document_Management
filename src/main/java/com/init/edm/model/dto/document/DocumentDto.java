package com.init.edm.model.dto.document;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Данные по документу, которые отобразятся на UI.
 *
 * @author GKordyukova
 */
public class DocumentDto {

    /**
     * Идентификатор документа
     */
    private UUID id;

    /**
     * Тип документа
     */
    private String type;

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
    private String author;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
