package com.init.edm.repository.staff.interfaces;

import com.init.edm.model.entity.staff.DepartmentStaff;

import java.util.List;
import java.util.UUID;

/**
 * Предоставляет методы для работы с репозиторием подразделений.
 *
 * @author GKordyukova
 */
public interface DepartmentsStaffRepository {

    /**
     * Найти подразделение по идентификатору.
     *
     * @param uuid идентификатор подразделения
     * @return {@link DepartmentStaff} найденное подразделение
     */
    DepartmentStaff findById(UUID uuid);

    /**
     * Получить список подразделений.
     *
     * @return List {@link DepartmentStaff} список подразделений
     */
    List<DepartmentStaff> findAll();

    /**
     * Добавить подразделение.
     *
     * @param departmentStaff подразделение
     * @return {@link DepartmentStaff} подразделение
     */
    DepartmentStaff save(DepartmentStaff departmentStaff);

    /**
     * Добавить список подразделений.
     *
     * @param departmentsStaff список подразделений
     * @return List {@link DepartmentStaff} список подразделений
     */
    List<DepartmentStaff> saveAll(List<DepartmentStaff> departmentsStaff);

    /**
     * Удалить подразделение по идентификатору.
     *
     * @param uuid идентификатор подразделения
     */
    void deleteById(UUID uuid);

    /**
     * Удалить все подразделения.
     *
     * @param departmentsStaff подразделение
     */
    void deleteAll(List<DepartmentStaff> departmentsStaff);
}
