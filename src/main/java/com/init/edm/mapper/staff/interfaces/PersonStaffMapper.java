package com.init.edm.mapper.staff.interfaces;

import com.init.edm.model.dto.staff.PersonStaffAllDto;
import com.init.edm.model.dto.staff.PersonStaffCreateDto;
import com.init.edm.model.dto.staff.PersonStaffDto;
import com.init.edm.model.entity.staff.PersonStaff;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Служит для конвертации сущности сотрудника в DTO или наоборот.
 *
 * @author GKordyukova
 */
public interface PersonStaffMapper {

    /**
     * Конвертировать сущность сотрудника в dto.
     *
     * @param personStaff сотрудник
     * @return {@link PersonStaffDto} Data Transfer Object сотрудников без фото
     */
    PersonStaffDto toDto(PersonStaff personStaff);

    /**
     * Конвертировать сущность сотрудника в dto.
     *
     * @param personStaff сотрудник
     * @return {@link PersonStaffAllDto} Data Transfer Object сотрудников с фото
     */
    PersonStaffAllDto toDtoAll(PersonStaff personStaff) throws IOException;

    /**
     * Конвертировать список сотрудников в dto.
     *
     * @param personsStaff список сотрудников
     * @return List {@link PersonStaffDto} сконвертированный список в необходимое нам представление
     */
    List<PersonStaffDto> toListDto(List<PersonStaff> personsStaff) throws IOException;

    /**
     * Конвертировать dto в сущность сотрудников.
     *
     * @param personStaffAllDto Dto для сотрудников
     * @return {@link PersonStaff} сущность "сотрудники"
     */
    PersonStaff toEntity(PersonStaffAllDto personStaffAllDto) throws URISyntaxException, IOException;

    /**
     * Конвертировать dto для создания сотрудников в сущность сотрудников.
     *
     * @param personStaffCreateDto Dto для создания сотрудников
     * @return {@link PersonStaff} сущность "сотрудники"
     */
    PersonStaff toEntity(PersonStaffCreateDto personStaffCreateDto) throws URISyntaxException, IOException;
}
