package com.init.edm.repository.staff.implementations;

import com.init.edm.model.entity.staff.PostStaff;
import com.init.edm.repository.staff.interfaces.PostStaffRepository;
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
 * Репозиторий для работы с должностями.
 *
 * @author GKordyukova
 */
@Repository
public class PostStaffRepositoryImpl implements PostStaffRepository {

    /**
     * Запрос на получение
     */
    private final String selectPostQuery = "SELECT * FROM Posttable";

    /**
     * Запрос на получение по id
     */
    private final String selectByIdPostQuery = "SELECT * FROM Posttable WHERE uuid = ?";

    /**
     * Запрос на вставку
     */
    private final String insertIntoPostQuery = "INSERT INTO Posttable (uuid, name) VALUES (?, ?)";

    /**
     * Запрос на удаление по id
     */
    private final String deleteByIdPostQuery = "DELETE FROM Posttable WHERE uuid = ?";

    /**
     * Запрос на удаление
     */
    private final String deletePostQuery = "DELETE FROM Posttable";

    /**
     * Получение DataSource
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Маппер должностей
     */
    @Autowired
    private StaffRepositoryMapper<PostStaff> postStaffRepositoryMapper;

    /**
     * Найти должность по uuid.
     *
     * @param uuid идентификатор должности
     * @return {@link PostStaff} искомая должность
     */
    @Override
    public PostStaff findById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdPostQuery)) {
            preparedStatement.setString(1, uuid.toString());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return postStaffRepositoryMapper.toEntity(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка соединения с базой данных в репозитории должностей.");
        }
    }

    /**
     * Найти все дожности.
     *
     * @return List {@link PostStaff} список должностей
     */
    @Override
    public List<PostStaff> findAll() {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectPostQuery);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            List<PostStaff> posts = new ArrayList<>();
            while (resultSet.next()) {
                posts.add(postStaffRepositoryMapper.toEntity(resultSet));
            }
            return posts;
        } catch (SQLException | URISyntaxException sqle) {
            throw new RuntimeException("Ошибка соединения с базой данных в репозитории должностей.");
        }
    }

    /**
     * Добавить должность.
     *
     * @param postStaff должность
     * @return {@link PostStaff} должность
     */
    @Override
    public PostStaff save(PostStaff postStaff) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertIntoPostQuery)) {
            preparedStatement.setString(1, postStaff.getUuid().toString());
            preparedStatement.setString(2, postStaff.getName());
            preparedStatement.executeUpdate();
            return postStaff;
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка соединения с базой данных в репозитории должностей.");
        }
    }

    /**
     * Добавить все должности.
     *
     * @param posts список должностей
     * @return List {@link PostStaff} список должностей
     */
    @Override
    public List<PostStaff> saveAll(List<PostStaff> posts) {
        for (PostStaff post : posts) {
            save(post);
        }
        return posts;
    }

    /**
     * Удалить должность по идентификатору.
     *
     * @param uuid идентификатор должности
     */
    @Override
    public void deleteById(UUID uuid) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteByIdPostQuery)) {
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка соединения с базой данных.");
        }
    }

    /**
     * Удалить все должности.
     *
     * @param posts список должностей
     */
    @Override
    public void deleteAll(List<PostStaff> posts) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deletePostQuery)) {
            preparedStatement.execute();
        } catch (SQLException sqle) {
            throw new RuntimeException("Ошибка соединения с базой данных.");
        }
    }
}
