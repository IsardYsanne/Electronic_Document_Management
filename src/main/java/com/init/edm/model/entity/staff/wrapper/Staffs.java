package com.init.edm.model.entity.staff.wrapper;

import com.init.edm.model.entity.staff.Staff;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * Представляет собой обертку для списка оргштатных единиц.
 *
 * @author GKordyukova
 */
@XmlRootElement(name = "staffRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class Staffs<T extends Staff> {

    /**
     * Список оргштатных единиц
     */
    @XmlElementWrapper(name = "staffs")
    @XmlElement(name = "staff")
    private List<T> staffs;

    public List<T> getStaffs() {
        return staffs;
    }
}
