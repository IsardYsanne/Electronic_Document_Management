package com.init.edm.utilities;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс для генерации случайных данных.
 *
 * @author GKordyukova
 */
@Component
public class RandomizerImpl implements Randomizer {

    /**
     * Сгенерировать число от start до end.
     *
     * @param start начальное значение
     * @param end   конечное значение включительно
     * @return int
     */
    @Override
    public int getRandomNumberBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    /**
     * Получить случайное перечисление, а вернуть случайный элемент перечисления.
     *
     * @param values случайный enum
     * @param <T>    тип enum
     * @return рандомный элемент из enum
     */
    @Override
    public <T extends Enum<T>> T getRandomEnumeration(Class<T> values) {
        T[] types = values.getEnumConstants();
        int length = types.length;
        return Arrays.asList(types).get(new Random().nextInt(length));
    }

    /**
     * Получить рандомный элемент из коллекции полей документа (название документа, текст документа, автор).
     *
     * @return {@link String}
     */
    @Override
    public <T> T getRandomDocumentField(List<T> fields) {
        return fields.get(new Random().nextInt(fields.size()));
    }
}
