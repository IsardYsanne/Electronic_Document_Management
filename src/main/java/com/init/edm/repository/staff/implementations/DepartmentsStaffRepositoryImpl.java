package com.init.edm.repository.staff.implementations;

import com.init.edm.model.entity.staff.DepartmentStaff;
import com.init.edm.repository.staff.interfaces.DepartmentsStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;

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
 * Репозиторий подразделений.
 *
 * @author GKordyukova
 */
@Repository
public class DepartmentsStaffRepositoryImpl implements DepartmentsStaffRepository {

    /**
     * Запрос на получение
     */
    private final String selectDepartmentsQuery = "SELECT * FROM Departments";

    /**
     * Запрос на получение по id
     */
    private final String selectByIdDepartmentsQuery = "SELECT * FROM Departments WHERE uuid = ?";

    /**
     * Запрос на вставку
     */
    private final String insertIntoDepartmentsQuery = "INSERT INTO Departments (uuid, fullName, shortName, manager, phones) VALUES(?, ?, ?, ?, ?)";

    /**
     * Запрос на удаление по id
     */
    private final String deleteByIdDepartmentsQuery = "DELETE FROM Departments WHERE uuid = ?";

    /**
     * Запрос на удаление
     */
    private final String deleteDepartmentsQuery = "DELETE FROM Departments";

    /**
     * Маппер для подразделений
     */
    @Autowired
    private StaffRepositoryMapper<DepartmentStaff> departmentRepositoryMapper;

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Найти подразделение по идентификатору.
     *
     * @param uuid идентификатор подразделения
     * @return {@link DepartmentStaff} найденное подразделение
     */
    @Override
    public DepartmentStaff findById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectByIdDepartmentsQuery)) {
            preparedStatement.setString(1, uuid.toString());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return departmentRepositoryMapper.toEntity(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка получения данных подразделения по id.");
        }
    }

    /**
     * Получить список подразделений.
     *
     * @return List {@link DepartmentStaff} список подразделений
     */
    @Override
    public List<DepartmentStaff> findAll() {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectDepartmentsQuery);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            List<DepartmentStaff> departments = new ArrayList<>();
            while (resultSet.next()) {
                departments.add(departmentRepositoryMapper.toEntity(resultSet));
            }
            return departments;
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка получения данных по подразделениям.");
        }
    }

    /**
     * Добавить подразделение.
     *
     * @param departmentStaff подразделение
     * @return {@link DepartmentStaff} подразделение
     */
    @Override
    public DepartmentStaff save(DepartmentStaff departmentStaff) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoDepartmentsQuery)) {
            preparedStatement.setString(1, departmentStaff.getUuid().toString());
            preparedStatement.setString(2, departmentStaff.getFullDepartmentName());
            preparedStatement.setString(3, departmentStaff.getShortDepartmentName());
            preparedStatement.setString(4, departmentStaff.getManager().getSurname());
            preparedStatement.setString(5, departmentStaff.getDepartmentPhones().stream().reduce("", (additionResult, phone) -> (additionResult + phone + " ")));
            preparedStatement.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка добавления данных по подразделению.");
        }
        return departmentStaff;
    }

    /**
     * Добавить список подразделений.
     *
     * @param departmentsStaff список подразделений
     * @return List {@link DepartmentStaff} список подразделений
     */
    @Override
    public List<DepartmentStaff> saveAll(List<DepartmentStaff> departmentsStaff) {
        for (DepartmentStaff department : departmentsStaff) {
            save(department);
        }
        return departmentsStaff;
    }

    /**
     * Удалить подразделение по идентификатору.
     *
     * @param uuid идентификатор подразделения
     */
    @Override
    public void deleteById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteByIdDepartmentsQuery)) {
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка удаления подразделения по id.");
        }
    }

    /**
     * Удалить все подразделения.
     *
     * @param departmentsStaff подразделения
     */
    @Override
    public void deleteAll(List<DepartmentStaff> departmentsStaff) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteDepartmentsQuery)) {
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка удаления подразделений.");
        }
    }
}