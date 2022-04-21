package com.init.edm.controller;

import com.init.edm.service.staff.PersonStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.init.edm.model.dto.staff.PersonStaffAllDto;
import com.init.edm.model.dto.staff.PersonStaffCreateDto;
import com.init.edm.model.dto.staff.PersonStaffDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Контроллер по работе с сотрудниками.
 *
 * @author GKordyukova
 */
@RestController
@RequestMapping("ecm/employees")
public class PersonController {

    /**
     * Сервис для сотрудников.
     */
    @Autowired
    private PersonStaffService personStaffService;

    /**
     * Найти сотрудника по идентификатору.
     *
     * @param id идентификатор сотрудника
     * @return {@link PersonStaffAllDto} дто сотрудника
     */
    @GetMapping("/{id}")
    public PersonStaffAllDto findById(@PathVariable String id) throws SQLException, IOException {
        return personStaffService.findById(UUID.fromString(id));
    }

    /**
     * Вывести всех сотрудников.
     *
     * @return List {@link PersonStaffDto} список сотрудников
     */
    @GetMapping("")
    public List<PersonStaffDto> findAll() throws IOException {
        return personStaffService.findAll();
    }

    /**
     * Удалить сотрудника по идентификатору.
     *
     * @param id идентификатор сотрудника
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        personStaffService.deleteById(UUID.fromString(id));
    }

    /**
     * Удалить всех сотрудников.
     */
    @DeleteMapping("/delete")
    public void deleteAll() {
        personStaffService.deleteAll();
    }

    /**
     * Создать сотрудника.
     *
     * @param personStaffCreateDto dto для создания сотрудника
     * @return {@link PersonStaffAllDto} сотрудник создан
     */
    @PostMapping("/create")
    public PersonStaffAllDto create(@RequestBody PersonStaffCreateDto personStaffCreateDto) throws URISyntaxException, IOException {
        return personStaffService.create(personStaffCreateDto);
    }

    /**
     * Изменить сотрудника по id
     *
     * @param personStaffAllDto dto для сотрудника
     * @return {@link PersonStaffAllDto} данные по сотруднику изменены
     */
    @PutMapping("/update/{id}")
    public PersonStaffAllDto update(@RequestBody PersonStaffAllDto personStaffAllDto) throws URISyntaxException, IOException {
        return personStaffService.update(personStaffAllDto);
    }
}
