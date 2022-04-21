package com.init.edm.repository.staff.filler.implementations;

import com.init.edm.repository.staff.interfaces.PostStaffRepository;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.init.edm.jaxb.JaxbReader;
import com.init.edm.repository.staff.filler.interfaces.PostStaffRepositoryFiller;

/**
 * Класс для заполнения репозитория должностей.
 *
 * @author GKordyukova
 */
@Component
public class PostStaffRepositoryFillerImpl implements PostStaffRepositoryFiller {

    /**
     * Репозиторий должностей
     */
    @Autowired
    private PostStaffRepository postStaffRepository;

    /**
     * Анмаршалер оргштатных единиц
     */
    @Autowired
    private JaxbReader jaxbReader;

    /**
     * Заполнить репозиторий должностей данными, загружаемыми из xml файла.
     *
     * @param fileName название файла
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    @Override
    public void fillPostStaffRepository(String fileName) throws JAXBException {
        if (postStaffRepository.findAll().size() == 0) {
            postStaffRepository.saveAll(jaxbReader.unmarshalStaff(fileName));
        }
    }
}
