package com.init.edm.repository.staff.implementations;

import com.init.edm.model.entity.staff.OrganizationStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;
import com.init.edm.repository.staff.interfaces.OrganizationsStaffRepository;

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
 * Репозиторий организаций.
 *
 * @author GKordyukova
 */
@Repository
public class OrganizationsStaffRepositoryImpl implements OrganizationsStaffRepository {

    /**
     * Запрос на получение
     */
    private final String selectOrganizationsQuery = "SELECT * FROM Organizations";

    /**
     * Запрос на получение по id
     */
    private final String selectByIdOrganizationsQuery = "SELECT * FROM Organizations WHERE uuid = ?";

    /**
     * Запрос на вставку
     */
    private final String insertIntoOrganizationsQuery = "INSERT INTO Organizations (uuid, fullName, shortName, director, phones) VALUES(?, ?, ?, ?, ?)";

    /**
     * Запрос на удаление по id
     */
    private final String deleteByIdOrganizationsQuery = "DELETE FROM Organizations WHERE uuid = ?";

    /**
     * Запрос на удаление
     */
    private final String deleteOrganizationsQuery = "DELETE FROM Organizations";

    /**
     * Маппер организаций
     */
    @Autowired
    private StaffRepositoryMapper<OrganizationStaff> organizationRepositoryMapper;

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Найти организацию по идентификатору.
     *
     * @param uuid идентификатор организации
     * @return {@link OrganizationStaff} найденная организация
     */
    @Override
    public OrganizationStaff findById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectByIdOrganizationsQuery)) {
            preparedStatement.setString(1, uuid.toString());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return organizationRepositoryMapper.toEntity(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка получения данных организации по id.");
        }
    }

    /**
     * Получить список организаций.
     *
     * @return List {@link OrganizationStaff}
     */
    @Override
    public List<OrganizationStaff> findAll() {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectOrganizationsQuery);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            List<OrganizationStaff> organizations = new ArrayList<>();
            while (resultSet.next()) {
                organizations.add(organizationRepositoryMapper.toEntity(resultSet));
            }
            return organizations;
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка получения данных по организациям.");
        }
    }

    /**
     * Добавить организацию.
     *
     * @param organizationStaff организация
     * @return {@link OrganizationStaff} организация
     */
    @Override
    public OrganizationStaff save(OrganizationStaff organizationStaff) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoOrganizationsQuery)) {
            preparedStatement.setString(1, organizationStaff.getUuid().toString());
            preparedStatement.setString(2, organizationStaff.getFullOrganizationName());
            preparedStatement.setString(3, organizationStaff.getShortOrganizationName());
            preparedStatement.setString(4, organizationStaff.getDirector().getSurname());
            preparedStatement.setString(5, organizationStaff.getOrganizationPhones().stream().reduce("", (additionResult, phone) -> (additionResult + phone + " ")));
            preparedStatement.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка добавления данных по организации.");
        }
        return organizationStaff;
    }

    /**
     * Добавить список организаций.
     *
     * @param organizationsStaff список организаций
     */
    @Override
    public List<OrganizationStaff> saveAll(List<OrganizationStaff> organizationsStaff) {
        for (OrganizationStaff organizationStaff : organizationsStaff) {
            save(organizationStaff);
        }
        return organizationsStaff;
    }

    /**
     * Удалить организацию по идентификатору.
     *
     * @param uuid идентификатор организации
     */
    @Override
    public void deleteById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteByIdOrganizationsQuery)) {
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка удаления организации по id.");
        }
    }

    /**
     * Удалить все организации.
     *
     * @param organizationsStaff организации
     */
    @Override
    public void deleteAll(List<OrganizationStaff> organizationsStaff) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteOrganizationsQuery)) {
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка удаления организаций.");
        }
    }
}
