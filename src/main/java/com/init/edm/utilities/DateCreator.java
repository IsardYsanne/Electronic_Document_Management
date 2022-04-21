package com.init.edm.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

/**
 * Класс производит генерацию даты.
 *
 * @author GKordyukova
 */
@Component
public class DateCreator {

    /**
     * Рандомайзер
     */
    @Autowired
    private Randomizer randomizer;

    /**
     * Сгенерировать дату
     *
     * @return {@link LocalDate}
     */
    public LocalDate createDate() {
        return LocalDate.of(randomizer.getRandomNumberBetween(2011, 2021), Month.of(randomizer.getRandomNumberBetween(1, 12)), randomizer.getRandomNumberBetween(1, 28));
    }

    /**
     * Сгенерировать дату - срок исполнения поручения
     *
     * @return {@link LocalDate}
     */
    public LocalDate setPeriodExecutionDate() {
        LocalDate date = createDate();
        LocalDate dateDay = date.plusDays(randomizer.getRandomNumberBetween(1, 28));
        LocalDate dateMonth = dateDay.plusMonths(randomizer.getRandomNumberBetween(1, 12));
        LocalDate dateYear = dateMonth.plusYears(1);
        return dateYear;
    }

    public LocalDate getDate() {
        return createDate();
    }
}
