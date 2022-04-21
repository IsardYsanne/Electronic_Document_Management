package com.init.edm.model.entity.document;

import com.init.edm.enums.DeliveryType;
import com.init.edm.model.entity.staff.PersonStaff;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.text.MessageFormat;

/**
 * Описывает характеристики исходящего документа.
 *
 * @author GKordyukova
 */
@XmlRootElement(name = "outgoingDocument")
public class OutgoingDocument extends Document {

    /**
     * Получатель
     */
    private PersonStaff addressee;

    /**
     * Способ доставки
     */
    private DeliveryType delivery;

    public PersonStaff getAddressee() {
        return addressee;
    }

    public DeliveryType getDelivery() {
        return delivery;
    }

    public void setAddressee(PersonStaff addressee) {
        this.addressee = addressee;
    }

    public void setDelivery(DeliveryType delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        MessageFormat messageFormat = new MessageFormat("Исходящий № {0} от {1} {2}");
        Object[] format = {getRegNumber(), getDate(), getName()};
        return messageFormat.format(format);
    }
}
