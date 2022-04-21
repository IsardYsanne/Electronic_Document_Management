package com.init.edm.jaxb;

import com.init.edm.model.entity.staff.Staff;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Component;
import com.init.edm.model.entity.staff.wrapper.Staffs;

import java.net.URL;
import java.util.List;

/**
 * Производит анмаршалинг оргштатных единиц из 3-х xml файлов.
 *
 * @author GKordyukova
 */
@Component
public class JaxbReaderImpl implements JaxbReader {

    /**
     * Преобразовать данные из xml в коллекцию оргштатных единиц.
     *
     * @param fileName название файла xml
     * @return List {@link T} список оргштатной единицы
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    @Override
    public <T extends Staff> List<T> unmarshalStaff(String fileName) throws JAXBException {
        URL url = JaxbReaderImpl.class.getClassLoader().getResource(fileName);
        JAXBContext jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory.createContext(new Class[]{Staffs.class}, null);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Staffs<T> staffs = (Staffs<T>) unmarshaller.unmarshal(url);
        return staffs.getStaffs();
    }
}
