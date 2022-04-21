package com.init.edm.model.entity.document;

import com.init.edm.model.entity.staff.PersonStaff;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.text.MessageFormat;
import java.time.LocalDate;

/**
 * Описывает характеристики входящего документа.
 *
 * @author GKordyukova
 */
@XmlRootElement(name = "incomingDocument")
public class IncomingDocument extends Document {

    /**
     * Отправитель документа
     */
    private PersonStaff sender;

    /**
     * Получатель
     */
    private PersonStaff addressee;

    /**
     * Исходящий номер
     */
    private Integer outgoingNumber;

    /**
     * Исходящая дата регистрации
     */
    private LocalDate outgoingDateRegistration;

    public PersonStaff getSender() {
        return sender;
    }

    public PersonStaff getAddressee() {
        return addressee;
    }

    public Integer getOutgoingNumber() {
        return outgoingNumber;
    }

    public LocalDate getOutgoingDateRegistration() {
        return outgoingDateRegistration;
    }

    public void setSender(PersonStaff sender) {
        this.sender = sender;
    }

    public void setAddressee(PersonStaff addressee) {
        this.addressee = addressee;
    }

    public void setOutgoingNumber(Integer outgoingNumber) {
        this.outgoingNumber = outgoingNumber;
    }

    public void setOutgoingDateRegistration(LocalDate outgoingDateRegistration) {
        this.outgoingDateRegistration = outgoingDateRegistration;
    }

    @Override
    public String toString() {
        MessageFormat messageFormat = new MessageFormat("Входящий № {0} от {1} {2}");
        Object[] format = {getRegNumber(), getDate(), getName()};
        return messageFormat.format(format);
    }
}
