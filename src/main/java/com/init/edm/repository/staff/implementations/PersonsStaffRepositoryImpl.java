package com.init.edm.repository.staff.implementations;

import com.init.edm.model.entity.staff.PersonStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;
import com.init.edm.repository.staff.interfaces.PersonsStaffRepository;

import javax.sql.DataSource;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Репозиторий сотрудников.
 *
 * @author GKordyukova
 */
@Repository
public class PersonsStaffRepositoryImpl implements PersonsStaffRepository {

    /**
     * Запрос на получение
     */
    private final String selectPersonsQuery = "SELECT * FROM Persons";

    /**
     * Запрос на получение по id
     */
    private final String selectByIdPersonsQuery = "SELECT * FROM Persons WHERE uuid LIKE ?";

    /**
     * Запрос на вставку
     */
    private final String insertIntoPersonsQuery = "INSERT INTO Persons (uuid, surname, name, patronymic, position, dateOfBirth, telephone, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     * Запрос на удаление по id
     */
    private final String deleteByIdPersonsQuery = "DELETE FROM Persons WHERE uuid = ?";

    /**
     * Запрос на удаление
     */
    private final String deletePersonsQuery = "DELETE FROM Persons";

    /**
     * Запрос на обновление
     */
    private final String updatePersonsQuery = "UPDATE Persons SET surname = ?, name = ?, patronymic = ?, position = ?, dateOfBirth = ?, telephone = ?, photo = ? WHERE uuid = ?";

    /**
     * Маппер для сотрудников
     */
    @Autowired
    private StaffRepositoryMapper<PersonStaff> personRepositoryMapper;

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Найти сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     * @return {@link PersonStaff} найденный сотрудник
     */
    @Override
    public PersonStaff findById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdPersonsQuery)) {
            preparedStatement.setString(1, uuid.toString());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return personRepositoryMapper.toEntity(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка получения данных сотрудника по id.");
        }
    }

    /**
     * Получить список сотрудников.
     *
     * @return List {@link PersonStaff} список сотрудников
     */
    public List<PersonStaff> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectPersonsQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<PersonStaff> persons = new ArrayList<>();
            while (resultSet.next()) {
                persons.add(personRepositoryMapper.toEntity(resultSet));
            }
            return persons;
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка получения данных по сотрудникам.");
        }
    }

    /**
     * Добавить сотрудника.
     *
     * @param personStaff сотрудник
     * @return {@link PersonStaff} сотрудник
     */
    @Override
    public PersonStaff save(PersonStaff personStaff) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement;
            if (findById(personStaff.getUuid()) == null) {
                preparedStatement = connection.prepareStatement(insertIntoPersonsQuery);
                preparedStatement.setString(1, personStaff.getUuid().toString());
                preparedStatement.setString(2, personStaff.getSurname());
                preparedStatement.setString(3, personStaff.getName());
                preparedStatement.setString(4, personStaff.getPatronymic());
                preparedStatement.setString(5, personStaff.getPosition().getName());
                preparedStatement.setDate(6, personStaff.getDateOfBirth());
                preparedStatement.setString(7, personStaff.getTelephone());
                preparedStatement.setString(8, personStaff.getPhoto().getName());
            } else {
                preparedStatement = connection.prepareStatement(updatePersonsQuery);
                preparedStatement.setString(1, personStaff.getSurname());
                preparedStatement.setString(2, personStaff.getName());
                preparedStatement.setString(3, personStaff.getPatronymic());
                preparedStatement.setString(4, personStaff.getPosition().getName());
                preparedStatement.setDate(5, personStaff.getDateOfBirth());
                preparedStatement.setString(6, personStaff.getTelephone());
                preparedStatement.setString(7, personStaff.getPhoto().getName());
                preparedStatement.setString(8, personStaff.getUuid().toString());
            }
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return personStaff;
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка добавления данных по сотруднику.");
        }
    }

    /**
     * Добавить список сотрудников.
     *
     * @param persons список сотрудников
     * @return List {@link PersonStaff} список сотрудников
     */
    @Override
    public List<PersonStaff> saveAll(List<PersonStaff> persons) {
        for (PersonStaff person : persons) {
            save(person);
        }
        return persons;
    }

    /**
     * Удалить сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника, которого надо удалить
     */
    @Override
    public void deleteById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteByIdPersonsQuery)) {
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка удаления сотрудника по id.");
        }
    }

    /**
     * Удалить всех сотрудников
     *
     * @param persons сотрудники, которых надо удалить
     */
    @Override
    public void deleteAll(List<PersonStaff> persons) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deletePersonsQuery)) {
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка удаления сотрудников.");
        }
    }
}
