package com.init.edm.enums;

/**
 * Типы документов.
 *
 * @author GKordyukova
 */
public enum DocumentsType {

    /**
     * Входящий документ
     */
    INCOMING("Incoming"),

    /**
     * Исходящий документ
     */
    OUTGOING("Outgoing"),

    /**
     * Поручение
     */
    TASK("Task");

    /**
     * Тип документа
     */
    private final String type;

    DocumentsType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
