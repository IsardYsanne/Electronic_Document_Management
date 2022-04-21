package com.init.edm.mapper.staff.interfaces;

import com.init.edm.model.entity.staff.Staff;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер для оргштатных единиц.
 *
 * @author GKordyukova
 */
public interface StaffRepositoryMapper <T extends Staff> {

    /**
     * Конвертировать в сущность данные из БД.
     *
     * @param resultSet данные из БД
     * @return {@link Staff} сущность оргштатной единицы
     * @throws SQLException возникает в случае ошибок доступа к базе данных или других ошибок
     */
    T toEntity(ResultSet resultSet) throws SQLException, URISyntaxException;
}
