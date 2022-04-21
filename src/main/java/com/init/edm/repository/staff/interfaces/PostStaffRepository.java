package com.init.edm.repository.staff.interfaces;

import com.init.edm.model.entity.staff.PostStaff;

import java.util.List;
import java.util.UUID;

/**
 * Репозиторий для работы с должностями.
 *
 * @author GKordyukova
 */
public interface PostStaffRepository {

    /**
     * Найти должность по uuid.
     *
     * @param uuid идентификатор должности
     * @return {@link PostStaff} искомая должность
     */
    PostStaff findById(UUID uuid);

    /**
     * Найти все дожности.
     *
     * @return List {@link PostStaff} список должностей
     */
    List<PostStaff> findAll();

    /**
     * Добавить должность.
     *
     * @param postStaff должность
     * @return {@link PostStaff} должность
     */
    PostStaff save(PostStaff postStaff);

    /**
     * Добавить все должности.
     *
     * @param posts список должностей
     * @return List {@link PostStaff} список должностей
     */
    List<PostStaff> saveAll(List<PostStaff> posts);

    /**
     * Удалить должность по идентификатору.
     *
     * @param uuid идентификатор должности
     */
    void deleteById(UUID uuid);

    /**
     * Удалить все должности.
     *
     * @param posts список должностей
     */
    void deleteAll(List<PostStaff> posts);
}
