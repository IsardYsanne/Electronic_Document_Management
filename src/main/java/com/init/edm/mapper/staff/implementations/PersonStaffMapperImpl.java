package com.init.edm.mapper.staff.implementations;

import com.init.edm.model.dto.staff.PersonStaffAllDto;
import com.init.edm.model.dto.staff.PersonStaffCreateDto;
import com.init.edm.model.dto.staff.PersonStaffDto;
import com.init.edm.model.entity.staff.PersonStaff;
import com.init.edm.photo.PhotoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.init.edm.mapper.staff.interfaces.PersonStaffMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * Служит для конвертации сущности сотрудника в DTO или наоборот.
 *
 * @author GKordyukova
 */
@Component
public class PersonStaffMapperImpl implements PersonStaffMapper {

    /**
     * Преобразователь для фото
     */
    @Autowired
    private PhotoHandler photoHandler;

    /**
     * Конвертировать сущность сотрудника в dto.
     *
     * @param personStaff сотрудник
     * @return {@link PersonStaffDto} Data Transfer Object сотрудников без фото
     */
    @Override
    public PersonStaffDto toDto(PersonStaff personStaff) {
        PersonStaffDto personStaffDto = new PersonStaffDto();
        personStaffDto.setId(personStaff.getUuid());
        personStaffDto.setSurname(personStaff.getSurname());
        personStaffDto.setName(personStaff.getName());
        personStaffDto.setPatronymic(personStaff.getPatronymic());
        personStaffDto.setDateOfBirth(personStaff.getDateOfBirth());
        personStaffDto.setPosition(personStaff.getPosition());
        personStaffDto.setTelephone(personStaff.getTelephone());
        return personStaffDto;
    }

    /**
     * Конвертировать сущность сотрудника в dto.
     *
     * @param personStaff сотрудник
     * @return {@link PersonStaffAllDto} Data Transfer Object сотрудников
     */
    @Override
    public PersonStaffAllDto toDtoAll(PersonStaff personStaff) throws IOException {
        PersonStaffAllDto personStaffAllDto = new PersonStaffAllDto();
        personStaffAllDto.setId(personStaff.getUuid());
        personStaffAllDto.setSurname(personStaff.getSurname());
        personStaffAllDto.setName(personStaff.getName());
        personStaffAllDto.setPatronymic(personStaff.getPatronymic());
        personStaffAllDto.setPosition(personStaff.getPosition());
        personStaffAllDto.setDateOfBirth(personStaff.getDateOfBirth());
        personStaffAllDto.setTelephone(personStaff.getTelephone());
        byte[] bytes = Files.readAllBytes(personStaff.getPhoto().toPath());
        personStaffAllDto.setPhoto(Base64.getEncoder().encodeToString(bytes));
        return personStaffAllDto;
    }

    /**
     * Конвертировать список сотрудников в dto.
     *
     * @param personsStaff список сотрудников
     * @return List {@link PersonStaffDto} сконвертированный список в необходимое нам представление
     */
    @Override
    public List<PersonStaffDto> toListDto(List<PersonStaff> personsStaff) {
        List<PersonStaffDto> personsStaffDto = new ArrayList<>();
        for (PersonStaff personStaff : personsStaff) {
            personsStaffDto.add(toDto(personStaff));
        }
        return personsStaffDto;
    }

    /**
     * Конвертировать dto в сущность сотрудников.
     *
     * @param personStaffAllDto Dto для сотрудников
     * @return {@link PersonStaff} сущность "сотрудники"
     */
    @Override
    public PersonStaff toEntity(PersonStaffAllDto personStaffAllDto) throws URISyntaxException, IOException {
        PersonStaff personStaff = new PersonStaff();
        personStaff.setUuid(personStaffAllDto.getId());
        personStaff.setSurname(personStaffAllDto.getSurname());
        personStaff.setName(personStaffAllDto.getName());
        personStaff.setPatronymic(personStaffAllDto.getPatronymic());
        personStaff.setPosition(personStaffAllDto.getPosition());
        personStaff.setDateOfBirth(new Date(personStaffAllDto.getDateOfBirth().getTime()));
        personStaff.setTelephone(personStaffAllDto.getTelephone());
        personStaff.setPhoto(photoHandler.convertToFile(personStaffAllDto.getPhoto(), personStaff.getSurname()));
        return personStaff;
    }

    /**
     * Конвертировать dto для создания сотрудников в сущность сотрудников.
     *
     * @param personStaffCreateDto Dto для создания сотрудников
     * @return {@link PersonStaff} сущность "сотрудники"
     */
    @Override
    public PersonStaff toEntity(PersonStaffCreateDto personStaffCreateDto) throws URISyntaxException, IOException {
        PersonStaff personStaff = new PersonStaff();
        personStaff.setUuid(UUID.randomUUID());
        personStaff.setSurname(personStaffCreateDto.getSurname());
        personStaff.setName(personStaffCreateDto.getName());
        personStaff.setPatronymic(personStaffCreateDto.getPatronymic());
        personStaff.setPosition(personStaffCreateDto.getPosition());
        personStaff.setDateOfBirth(new Date(personStaffCreateDto.getDateOfBirth().getTime()));
        personStaff.setTelephone(personStaffCreateDto.getTelephone());
        personStaff.setPhoto(photoHandler.convertToFile(personStaffCreateDto.getPhoto(), personStaff.getSurname()));
        return personStaff;
    }
}
