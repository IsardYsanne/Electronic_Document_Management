package com.init.edm.mapper.staff.implementations;

import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;
import com.init.edm.model.entity.staff.OrganizationStaff;
import com.init.edm.repository.staff.interfaces.PersonsStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

/**
 * Маппер для организаций.
 *
 * @author GKordyukova
 */
@Component
public class OrganizationRepositoryMapperImpl implements StaffRepositoryMapper<OrganizationStaff> {

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    private PersonsStaffRepository personsStaffRepository;

    /**
     * Конвертировать в сущность данные из БД.
     *
     * @param resultSet данные из БД
     * @return {@link OrganizationStaff} сущность "Организации"
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    @Override
    public OrganizationStaff toEntity(ResultSet resultSet) throws SQLException {
        OrganizationStaff organization = new OrganizationStaff();
        organization.setUuid(UUID.fromString(resultSet.getString(1)));
        organization.setFullOrganizationName(resultSet.getString(2));
        organization.setShortOrganizationName(resultSet.getString(3));
        String surname = resultSet.getString(4);
        organization.setDirector(personsStaffRepository.findAll().stream().filter(person -> person.getSurname().equals(surname)).findFirst().orElse(null));
        organization.setOrganizationPhones(Arrays.asList(resultSet.getString(5).split(" ")));
        return organization;
    }
}
