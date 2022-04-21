package com.init.edm.factory;

import com.init.edm.enums.DeliveryType;
import com.init.edm.model.entity.staff.PersonStaff;
import org.springframework.stereotype.Component;
import com.init.edm.model.entity.document.Document;
import com.init.edm.model.entity.document.OutgoingDocument;

import java.util.List;
import java.util.Random;

/**
 * Представляет собой фабричный метод для создания и заполнения полей Исходящего документа случайными значениями.
 *
 * @author GKordyukova
 */
@Component("Outgoing")
public class OutgoingFactory extends DocumentFactory {

    /**
     * Создать документ, заполнив поля документа {@link OutgoingDocument}
     *
     * @return {@link Document} документ
     */
    @Override
    public Document create() {
        OutgoingDocument outgoingDocument = new OutgoingDocument();
        super.generateDocumentFields(outgoingDocument);
        List<PersonStaff> employees = personsStaffRepository.findAll();
        Integer randomNumberOfAddressee = new Random().nextInt(employees.size());
        PersonStaff addressee = employees.get(randomNumberOfAddressee);
        DeliveryType delivery = randomizer.getRandomEnumeration(DeliveryType.class);
        outgoingDocument.setAddressee(addressee);
        outgoingDocument.setDelivery(delivery);
        return outgoingDocument;
    }
}
