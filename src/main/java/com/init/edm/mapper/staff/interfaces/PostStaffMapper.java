package com.init.edm.mapper.staff.interfaces;

import com.init.edm.model.dto.staff.PostStaffAllDto;
import com.init.edm.model.dto.staff.PostStaffDto;
import com.init.edm.model.entity.staff.PostStaff;

import java.util.List;

/**
 * Маппер для должности.
 *
 * @author GKordyukova
 */
public interface PostStaffMapper {

    /**
     * Конвертировать сущность должности в dto.
     *
     * @param postStaff должнсть
     * @return {@link PostStaffDto} dto для должности
     */
    PostStaffDto toDto(PostStaff postStaff);

    /**
     * Конвертировать должности сотрудников в dto.
     *
     * @param postsStaff список должностей
     * @return List {@link PostStaffAllDto} сконвертированный список в необходимое нам представление
     */
    List<PostStaffAllDto> toListDto(List<PostStaff> postsStaff);

    /**
     * Конвертировать dto в сущность должностей.
     *
     * @param postStaffDto dto должности
     * @return сущность должности
     */
    PostStaff toEntity(PostStaffDto postStaffDto);

    /**
     * Конвертировать сущность должности в dto.
     *
     * @param postStaff список должностей
     * @return {@link PostStaffAllDto} dto для должности
     */
    PostStaffAllDto toAllDto(PostStaff postStaff);
}
