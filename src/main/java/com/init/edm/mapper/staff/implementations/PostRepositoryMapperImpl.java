package com.init.edm.mapper.staff.implementations;

import com.init.edm.model.entity.staff.PostStaff;
import org.springframework.stereotype.Component;
import com.init.edm.mapper.staff.interfaces.StaffRepositoryMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Маппер для должностей.
 *
 * @author GKordyukova
 */
@Component
public class PostRepositoryMapperImpl implements StaffRepositoryMapper<PostStaff> {

    /**
     * Конвертировать в сущность данные из БД.
     *
     * @param resultSet данные из БД
     * @return {@link PostStaff} сущность "Должности"
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    @Override
    public PostStaff toEntity(ResultSet resultSet) throws SQLException {
        PostStaff postStaff = new PostStaff();
        postStaff.setUuid(UUID.fromString(resultSet.getString(1)));
        postStaff.setName(resultSet.getString(2));
        return postStaff;
    }
}
