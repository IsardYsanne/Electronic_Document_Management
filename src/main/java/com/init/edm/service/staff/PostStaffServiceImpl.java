package com.init.edm.service.staff;

import com.init.edm.mapper.staff.interfaces.PostStaffMapper;
import com.init.edm.model.dto.staff.PostStaffAllDto;
import com.init.edm.model.dto.staff.PostStaffDto;
import com.init.edm.repository.staff.interfaces.PostStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для должностей.
 *
 * @author GKordyukova
 */
@Service
public class PostStaffServiceImpl implements PostStaffService {

    /**
     * Маппер для должности
     */
    @Autowired
    private PostStaffMapper postStaffMapper;

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    private PostStaffRepository postStaffRepository;

    /**
     * Найти должность по uuid.
     *
     * @param uuid идентификатор должности
     * @return {@link PostStaffAllDto} искомая должность
     */
    @Override
    public PostStaffAllDto findById(UUID uuid) {
        return postStaffMapper.toAllDto(postStaffRepository.findById(uuid));
    }

    /**
     * Найти все дожности.
     *
     * @return List {@link PostStaffAllDto} список должностей
     */
    @Override
    public List<PostStaffAllDto> findAll() {
        return postStaffMapper.toListDto(postStaffRepository.findAll());
    }

    /**
     * Удалить должность по идентификатору.
     *
     * @param uuid идентификатор должности
     */
    @Override
    public void deleteById(UUID uuid) {
        postStaffRepository.deleteById(uuid);
    }

    /**
     * Удалить все должности.
     */
    @Override
    public void deleteAll() {
        postStaffRepository.deleteAll(postStaffRepository.findAll());
    }

    /**
     * Создать должность.
     *
     * @param postStaffDto должность
     * @return {@link PostStaffDto} должность
     */
    @Override
    public PostStaffDto create(PostStaffDto postStaffDto) {
        return postStaffMapper.toDto(postStaffRepository.save(postStaffMapper.toEntity(postStaffDto)));
    }
}
