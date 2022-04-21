package com.init.edm.factory;

import com.init.edm.model.entity.staff.PersonStaff;
import org.springframework.stereotype.Component;
import com.init.edm.model.entity.document.Document;
import com.init.edm.model.entity.document.IncomingDocument;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Представляет собой фабричный метод для создания и заполнения полей Входящего документа случайными значениями.
 *
 * @author GKordyukova
 */
@Component("Incoming")
public class IncomingFactory extends DocumentFactory {

    /**
     * Создать документ, заполнив поля документа {@link IncomingDocument}
     *
     * @return {@link Document} документ
     */
    @Override
    public Document create() {
        IncomingDocument incomingDocument = new IncomingDocument();
        super.generateDocumentFields(incomingDocument);
        List<PersonStaff> employees = personsStaffRepository.findAll();
        Integer randomNumberOfSender = new Random().nextInt(employees.size());
        Integer randomNumberOfAddressee = new Random().nextInt(employees.size());
        PersonStaff sender = employees.get(randomNumberOfSender);
        PersonStaff addressee = employees.get(randomNumberOfAddressee);
        Integer outgoingNumber = randomizer.getRandomNumberBetween(1, 30);
        LocalDate outgoingDate = dateCreator.createDate();
        incomingDocument.setSender(sender);
        incomingDocument.setAddressee(addressee);
        incomingDocument.setOutgoingNumber(outgoingNumber);
        incomingDocument.setOutgoingDateRegistration(outgoingDate);
        return incomingDocument;
    }
}
