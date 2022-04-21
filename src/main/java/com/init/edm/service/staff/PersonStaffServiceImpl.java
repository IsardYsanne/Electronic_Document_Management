package com.init.edm.service.staff;

import com.init.edm.mapper.staff.interfaces.PersonStaffMapper;
import com.init.edm.model.dto.staff.PersonStaffAllDto;
import com.init.edm.model.dto.staff.PersonStaffCreateDto;
import com.init.edm.model.dto.staff.PersonStaffDto;
import com.init.edm.model.entity.staff.PersonStaff;
import com.init.edm.repository.staff.interfaces.PersonsStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class PersonStaffServiceImpl implements PersonStaffService {

    /**
     * Маппер сотрудников
     */
    @Autowired
    private PersonStaffMapper personStaffMapper;

    /**
     * Репозиторий сотрудников
     */
    @Autowired
    private PersonsStaffRepository personsStaffRepository;

    /**
     * Найти сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     * @return {@link PersonStaffAllDto} найденный сотрудник
     */
    @Override
    public PersonStaffAllDto findById(UUID uuid) throws SQLException, IOException {
        return personStaffMapper.toDtoAll(personsStaffRepository.findById(uuid));
    }

    /**
     * Получить список сотрудников.
     *
     * @return List {@link PersonStaffDto} список сотрудников
     */
    @Override
    public List<PersonStaffDto> findAll() throws IOException {
        return personStaffMapper.toListDto(personsStaffRepository.findAll());
    }

    /**
     * Создать нового сотрудника
     *
     * @param personStaffCreateDto сотрудник
     * @return {@link PersonStaffAllDto} сотрудник
     */
    @Override
    public PersonStaffAllDto create(PersonStaffCreateDto personStaffCreateDto) throws URISyntaxException, IOException {
        PersonStaff personStaff = personStaffMapper.toEntity(personStaffCreateDto);
        return personStaffMapper.toDtoAll(personsStaffRepository.save(personStaff));
    }

    /**
     * Обновить данные по сотруднику
     *
     * @param personStaffAllDto список сотрудников
     * @return List {@link PersonStaffAllDto} список сотрудников
     */
    @Override
    public PersonStaffAllDto update(PersonStaffAllDto personStaffAllDto) throws URISyntaxException, IOException {
        PersonStaff personStaff = personStaffMapper.toEntity(personStaffAllDto);
        return personStaffMapper.toDtoAll(personsStaffRepository.save(personStaff));
    }

    /**
     * Удалить сотрудника по идентификатору.
     *
     * @param uuid идентификатор сотрудника
     */
    @Override
    public void deleteById(UUID uuid) {
        personsStaffRepository.deleteById(uuid);
    }

    /**
     * Удалить всех сотрудников.
     */
    @Override
    public void deleteAll() {
        personsStaffRepository.deleteAll(personsStaffRepository.findAll());
    }
}
