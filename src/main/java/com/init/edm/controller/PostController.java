package com.init.edm.controller;

import com.init.edm.model.dto.staff.PostStaffAllDto;
import com.init.edm.model.dto.staff.PostStaffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.init.edm.service.staff.PostStaffService;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер для работы с должностями сотрудников.
 *
 * @author GKordyukova
 */
@RestController
@RequestMapping("ecm/post")
public class PostController {

    /**
     * Сервис для должности
     */
    @Autowired
    private PostStaffService postStaffService;

    /**
     * Найти должность по идентификатору.
     *
     * @param id идентификатор должности
     * @return {@link PostStaffAllDto} дто должности
     */
    @GetMapping("/{id}")
    public PostStaffAllDto findById(@PathVariable String id) {
        return postStaffService.findById(UUID.fromString(id));
    }

    /**
     * Вывести все должности.
     *
     * @return List {@link PostStaffAllDto} список всех должностей
     */
    @GetMapping("")
    public List<PostStaffAllDto> findAll() {
        return postStaffService.findAll();
    }

    /**
     * Удалить должность по идентификатору.
     *
     * @param id идентификатор должности
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        postStaffService.deleteById(UUID.fromString(id));
    }

    /**
     * Удалить все должности.
     */
    @DeleteMapping("/delete")
    public void deleteAll() {
        postStaffService.deleteAll();
    }

    /**
     * Создать должность.
     *
     * @param postStaffDto дто данных по должности
     * @return {@link PostStaffDto} должность создана
     */
    @PostMapping("/create")
    public PostStaffDto create(@RequestBody PostStaffDto postStaffDto) {
        return postStaffService.create(postStaffDto);
    }
}
