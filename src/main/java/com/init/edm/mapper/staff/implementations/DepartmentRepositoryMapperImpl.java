package com.init.edm.mapper.staff.implementations;

import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;
import com.init.edm.model.entity.staff.DepartmentStaff;
import com.init.edm.repository.staff.interfaces.PersonsStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

/**
 * Маппер для подразделений.
 *
 * @author GKordyukova
 */
@Component
public class DepartmentRepositoryMapperImpl implements StaffRepositoryMapper<DepartmentStaff> {

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    private PersonsStaffRepository personsStaffRepository;

    /**
     * Конвертировать в сущность данные из БД.
     *
     * @param resultSet данные из БД
     * @return {@link DepartmentStaff} сущность "Подразделения"
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    @Override
    public DepartmentStaff toEntity(ResultSet resultSet) throws SQLException {
        DepartmentStaff departmentStaff = new DepartmentStaff();
        departmentStaff.setUuid(UUID.fromString(resultSet.getString(1)));
        departmentStaff.setFullDepartmentName(resultSet.getString(2));
        departmentStaff.setShortDepartmentName(resultSet.getString(3));
        String surname = resultSet.getString(4);
        departmentStaff.setManager(personsStaffRepository.findAll().stream().filter(person -> person.getSurname().equals(surname)).findFirst().orElse(null));
        departmentStaff.setDepartmentPhones(Arrays.asList(resultSet.getString(5).split(" ")));
        return departmentStaff;
    }
}
