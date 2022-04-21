package com.init.edm.jaxb;

import com.init.edm.model.entity.staff.Staff;
import jakarta.xml.bind.JAXBException;

import java.util.List;

/**
 * Предоставляет метод для анмаршалинга оргштатных единиц из 3-х xml файлов.
 *
 * @author GKordyukova
 */
public interface JaxbReader {

    /**
     * Преобразовать данные из xml в коллекцию оргштатных единиц.
     *
     * @param fileName название файла xml
     * @return List {@link T} список оргштатной единицы
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     */
    <T extends Staff> List<T> unmarshalStaff(String fileName) throws JAXBException;
}
