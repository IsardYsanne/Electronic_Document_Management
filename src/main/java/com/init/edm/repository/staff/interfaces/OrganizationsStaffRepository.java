package com.init.edm.repository.staff.interfaces;

import com.init.edm.model.entity.staff.OrganizationStaff;

import java.util.List;
import java.util.UUID;

/**
 * Предоставляет методы для работы с репозиторием организаций.
 *
 * @author GKordyukova
 */
public interface OrganizationsStaffRepository {

    /**
     * Найти организацию по идентификатору.
     *
     * @param uuid идентификатор организации
     * @return {@link OrganizationStaff} найденная организация
     */
    OrganizationStaff findById(UUID uuid);

    /**
     * Получить список организаций.
     *
     * @return List {@link OrganizationStaff} список организаций
     */
    List<OrganizationStaff> findAll();

    /**
     * Добавить организацию.
     *
     * @param organizationStaff организация
     * @return {@link OrganizationStaff} организация
     */
    OrganizationStaff save(OrganizationStaff organizationStaff);

    /**
     * Добавить список организаций.
     *
     * @param organizationsStaff список организаций
     * @return List {@link OrganizationStaff} список организаций
     */
    List<OrganizationStaff> saveAll(List<OrganizationStaff> organizationsStaff);

    /**
     * Удалить организацию по идентификатору.
     *
     * @param uuid идентификатор организации
     */
    void deleteById(UUID uuid);

    /**
     * Удалить все организации.
     *
     * @param organizationsStaff организация
     */
    void deleteAll(List<OrganizationStaff> organizationsStaff);
}
