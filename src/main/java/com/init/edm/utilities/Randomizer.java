package com.init.edm.utilities;

import java.util.List;

/**
 * Служит для генерации случайных данных.
 *
 * @author GKordyukova
 */
public interface Randomizer {

    /**
     * Сгенерировать число от start до end.
     *
     * @param start начальное значение
     * @param end   конечное значение включительно
     * @return int
     */
    int getRandomNumberBetween(int start, int end);

    /**
     * Получить случайное перечисление, а вернуть случайный элемент перечисления.
     *
     * @param values случайный enum
     * @param <T>    тип enum
     * @return рандомный элемент из enum
     */
    <T extends Enum<T>> T getRandomEnumeration(Class<T> values);

    /**
     * Получить рандомный элемент из коллекции полей документа (название документа, текст документа, автор).
     *
     * @return {@link String}
     */
    <T> T getRandomDocumentField(List<T> fields);
}
