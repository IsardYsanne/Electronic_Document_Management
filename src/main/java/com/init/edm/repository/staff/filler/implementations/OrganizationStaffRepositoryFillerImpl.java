package com.init.edm.repository.staff.filler.implementations;

import com.init.edm.repository.staff.filler.interfaces.OrganizationStaffRepositoryFiller;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.init.edm.repository.staff.interfaces.OrganizationsStaffRepository;
import com.init.edm.jaxb.JaxbReader;

/**
 * Класс для заполнения репозитория организаций.
 *
 * @author GKordyukova
 */
@Component
public class OrganizationStaffRepositoryFillerImpl implements OrganizationStaffRepositoryFiller {

    /**
     * Репозиторий организаций
     */
    @Autowired
    private OrganizationsStaffRepository organizationsStaffRepository;

    /**
     * Анмаршалер оргштатных единиц
     */
    @Autowired
    private JaxbReader jaxbReader;

    /**
     * Заполнить репозиторий, базу данных организаций данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    @Override
    public void fillOrganizationStaffRepository(String fileName) throws JAXBException {
        if (organizationsStaffRepository.findAll().size() == 0) {
            organizationsStaffRepository.saveAll(jaxbReader.unmarshalStaff(fileName));
        }
    }
}
