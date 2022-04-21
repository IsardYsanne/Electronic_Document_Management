package com.init.edm.mapper.staff.implementations;

import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;
import com.init.edm.model.entity.staff.PersonStaff;
import com.init.edm.photo.PhotoHandler;
import com.init.edm.repository.staff.interfaces.PostStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Маппер для сотрудников.
 *
 * @author GKordyukova
 */
@Component
public class PersonRepositoryMapperImpl implements StaffRepositoryMapper<PersonStaff> {

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    private PostStaffRepository postStaffRepository;

    /**
     * Преобразователь для фото
     */
    @Autowired
    private PhotoHandler photoHandler;

    /**
     * Конвертировать в сущность данные из БД.
     *
     * @param resultSet данные из БД
     * @return {@link PersonStaff} сущность "Сотрудники"
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    @Override
    public PersonStaff toEntity(ResultSet resultSet) throws SQLException, URISyntaxException {
        PersonStaff personStaff = new PersonStaff();
        personStaff.setUuid(UUID.fromString(resultSet.getString(1)));
        personStaff.setSurname(resultSet.getString(2));
        personStaff.setName(resultSet.getString(3));
        personStaff.setPatronymic(resultSet.getString(4));
        String postName = resultSet.getString(5);
        personStaff.setPosition(postStaffRepository.findAll().stream().filter(post -> post.getName().equals(postName)).findFirst().orElse(null));
        personStaff.setDateOfBirth(resultSet.getDate(6));
        personStaff.setTelephone(resultSet.getString(7));
        personStaff.setPhoto(photoHandler.convertNameToFile(resultSet.getString(8)));
        return personStaff;
    }
}
