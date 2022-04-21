package com.init.edm.repository.staff.interfaces;

import com.init.edm.model.entity.staff.PersonStaff;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Предоставляет методы для работы с репозиторием сотрудников.
 *
 * @author GKordyukova
 */
public interface PersonsStaffRepository {

    /**
     * Найти сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     * @return {@link PersonStaff} найденный сотрудник
     */
    PersonStaff findById(UUID uuid) throws SQLException;

    /**
     * Получить список сотрудников.
     *
     * @return List {@link PersonStaff} список сотрудников
     */
    List<PersonStaff> findAll();

    /**
     * Добавить сотрудника.
     *
     * @param personStaff сотрудник
     * @return {@link PersonStaff} сотрудник
     */
    PersonStaff save(PersonStaff personStaff);

    /**
     * Добавить список сотрудников.
     *
     * @param persons список сотрудников
     * @return List {@link PersonStaff} список сотрудников
     */
    List<PersonStaff> saveAll(List<PersonStaff> persons) throws SQLException;

    /**
     * Удалить сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     */
    void deleteById(UUID uuid);

    /**
     * Удалить всех сотрудников.
     *
     * @param persons сотрудники
     */
    void deleteAll(List<PersonStaff> persons);
}
