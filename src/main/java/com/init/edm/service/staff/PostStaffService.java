package com.init.edm.service.staff;

import com.init.edm.model.dto.staff.PostStaffAllDto;
import com.init.edm.model.dto.staff.PostStaffDto;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для должностей.
 *
 * @author GKordyukova
 */
public interface PostStaffService {

    /**
     * Найти должность по uuid.
     *
     * @param uuid идентификатор должности
     * @return {@link PostStaffAllDto} искомая должность
     */
    PostStaffAllDto findById(UUID uuid);

    /**
     * Найти все дожности.
     *
     * @return List {@link PostStaffAllDto} список должностей
     */
    List<PostStaffAllDto> findAll();

    /**
     * Создать должность.
     *
     * @param postStaffDto должность
     * @return {@link PostStaffDto} должность
     */
    PostStaffDto create(PostStaffDto postStaffDto);

    /**
     * Удалить должность по идентификатору.
     *
     * @param uuid идентификатор должности
     */
    void deleteById(UUID uuid);

    /**
     * Удалить все должности.
     */
    void deleteAll();
}
