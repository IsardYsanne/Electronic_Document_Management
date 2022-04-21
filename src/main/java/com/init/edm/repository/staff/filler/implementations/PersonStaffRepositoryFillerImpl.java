package com.init.edm.repository.staff.filler.implementations;

import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.init.edm.repository.staff.interfaces.PersonsStaffRepository;
import com.init.edm.repository.staff.filler.interfaces.PersonStaffRepositoryFiller;
import com.init.edm.jaxb.JaxbReader;

import java.sql.SQLException;

/**
 * Класс для заполнения репозитория сотрудников.
 *
 * @author GKordyukova
 */
@Component
public class PersonStaffRepositoryFillerImpl implements PersonStaffRepositoryFiller {

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    private PersonsStaffRepository personsStaffRepository;

    /**
     * Анмаршалер оргштатных единиц
     */
    @Autowired
    private JaxbReader jaxbReader;

    /**
     * Заполнить репозиторий, базу данных сотрудников данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    @Override
    public void fillPersonStaffRepository(String fileName) throws JAXBException, SQLException {
        if (personsStaffRepository.findAll().size() == 0) {
            personsStaffRepository.saveAll(jaxbReader.unmarshalStaff(fileName));
        }
    }
}
