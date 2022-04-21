package com.init.edm.storage.document;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с коллекцией регистрационных номеров.
 *
 * @author GKordyukova
 */
@Component
public class RegistrationNumbersStorage {

    /**
     * Список регистрационных номеров
     */
    public List<Integer> numbers = new ArrayList<>();

    /**
     * Получить список регистрационных номеров.
     *
     * @return List {@link Integer} список номеров
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}
