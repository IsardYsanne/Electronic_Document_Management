package com.init.edm.mapper.staff.implementations;

import com.init.edm.model.dto.staff.PostStaffAllDto;
import com.init.edm.model.dto.staff.PostStaffDto;
import com.init.edm.model.entity.staff.PostStaff;
import org.springframework.stereotype.Component;
import com.init.edm.mapper.staff.interfaces.PostStaffMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Реализация маппера для должности.
 *
 * @author GKordyukova
 */
@Component
public class PostStaffMapperImpl implements PostStaffMapper {

    /**
     * Конвертировать сущность должности в dto.
     *
     * @param postStaff должнсть
     * @return {@link PostStaffDto} dto для должности
     */
    @Override
    public PostStaffDto toDto(PostStaff postStaff) {
        PostStaffDto postStaffDto = new PostStaffDto();
        postStaffDto.setName(postStaff.getName());
        return postStaffDto;
    }

    /**
     * Конвертировать сущность должности в dto.
     *
     * @param postStaff список должностей
     * @return {@link PostStaffAllDto} dto для должности
     */
    @Override
    public PostStaffAllDto toAllDto(PostStaff postStaff) {
        PostStaffAllDto postStaffAllDto = new PostStaffAllDto();
        postStaffAllDto.setId(postStaff.getUuid());
        postStaffAllDto.setName(postStaff.getName());
        return postStaffAllDto;
    }

    /**
     * Конвертировать должностей сотрудников в dto.
     *
     * @param postsStaff список должностей
     * @return List {@link PostStaffAllDto} сконвертированный список в необходимое нам представление
     */
    @Override
    public List<PostStaffAllDto> toListDto(List<PostStaff> postsStaff) {
        List<PostStaffAllDto> postsAllStaffDto = new ArrayList<>();
        for (PostStaff postStaff : postsStaff) {
            postsAllStaffDto.add(toAllDto(postStaff));
        }
        return postsAllStaffDto;
    }

    /**
     * Конвертировать dto в сущность должностей.
     *
     * @param postStaffDto dto должности
     * @return сущность должности
     */
    @Override
    public PostStaff toEntity(PostStaffDto postStaffDto) {
        PostStaff postStaff = new PostStaff();
        postStaff.setUuid(UUID.randomUUID());
        postStaff.setName(postStaffDto.getName());
        return postStaff;
    }
}
