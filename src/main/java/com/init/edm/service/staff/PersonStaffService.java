package com.init.edm.service.staff;

import com.init.edm.model.dto.staff.PersonStaffAllDto;
import com.init.edm.model.dto.staff.PersonStaffCreateDto;
import com.init.edm.model.dto.staff.PersonStaffDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Сервис для работников.
 *
 * @author GKordyukova
 */
public interface PersonStaffService {

    /**
     * Найти сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     * @return {@link PersonStaffAllDto} найденный сотрудник
     */
    PersonStaffAllDto findById(UUID uuid) throws SQLException, IOException;

    /**
     * Получить список сотрудников.
     *
     * @return List {@link PersonStaffDto} список сотрудников
     */
    List<PersonStaffDto> findAll() throws IOException;

    /**
     * Создать нового сотрудника.
     *
     * @param personStaffCreateDto сотрудник
     * @return {@link PersonStaffAllDto} сотрудник
     */
    PersonStaffAllDto create(PersonStaffCreateDto personStaffCreateDto) throws URISyntaxException, IOException;

    /**
     * Обновить данные по сотруднику.
     *
     * @param personStaffAllDto список сотрудников
     * @return List {@link PersonStaffAllDto} список сотрудников
     */
    PersonStaffAllDto update(PersonStaffAllDto personStaffAllDto) throws URISyntaxException, IOException;

    /**
     * Удалить сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     */
    void deleteById(UUID uuid);

    /**
     * Удалить всех сотрудников.
     */
    void deleteAll();
}
