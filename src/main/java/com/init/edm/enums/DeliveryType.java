package com.init.edm.enums;

import java.text.MessageFormat;

/**
 * Способы доставки исходящего документа.
 *
 * @author GKordyukova
 */
public enum DeliveryType {

    /**
     * Доставка с помощью факса
     */
    FAX("Fax"),

    /**
     * Доставка с помощью электронной почты
     */
    EMAIL("Email");

    /**
     * Тип доставки
     */
    private String type;

    DeliveryType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        MessageFormat messageFormat = new MessageFormat("Тип: {0}");
        Object[] format = {type};
        return messageFormat.format(format);
    }
}
