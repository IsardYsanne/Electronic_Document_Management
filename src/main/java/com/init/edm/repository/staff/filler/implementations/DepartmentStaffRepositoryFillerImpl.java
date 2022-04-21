package com.init.edm.repository.staff.filler.implementations;

import com.init.edm.jaxb.JaxbReader;
import com.init.edm.repository.staff.filler.interfaces.DepartmentStaffRepositoryFiller;
import com.init.edm.repository.staff.interfaces.DepartmentsStaffRepository;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс для заполнения репозитория подразделений.
 *
 * @author GKordyukova
 */
@Component
public class DepartmentStaffRepositoryFillerImpl implements DepartmentStaffRepositoryFiller {

    /**
     * Репозиторий подразделений
     */
    @Autowired
    private DepartmentsStaffRepository departmentsStaffRepository;

    /**
     * Анмаршалер оргштатных единиц
     */
    @Autowired
    private JaxbReader jaxbReader;

    /**
     * Заполнить репозиторий, базу данных подразделений данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    @Override
    public void fillDepartmentStaffRepository(String fileName) throws JAXBException {
        if (departmentsStaffRepository.findAll().size() == 0) {
            departmentsStaffRepository.saveAll(jaxbReader.unmarshalStaff(fileName));
        }
    }
}
