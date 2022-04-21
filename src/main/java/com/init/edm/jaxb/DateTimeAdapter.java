package com.init.edm.jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Фрматирует дату в пользовательский формат при анмаршалинге.
 *
 * @author GKordyukova
 */
public class DateTimeAdapter extends XmlAdapter<String, Date> {

    /**
     * Представление даты реализовано в данном формате
     */
    public static DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    /**
     * Преобразовывать дату при анмаршалинге.
     *
     * @param date дата, которую необходимо форматировать
     * @return {@link Date} возращаемая дата
     * @throws ParseException сообщает о том, что при синтаксическом анализе возникла ошибка.
     */
    @Override
    public Date unmarshal(String date) throws ParseException {
        return new Date(DATE_FORMAT.parse(date).getTime());
    }

    /**
     * Преобразовывать дату в строковый тип.
     *
     * @param date дата, которую необходимо форматировать
     * @return {@link String} возращаемая строка
     */
    @Override
    public String marshal(Date date) {
        return DATE_FORMAT.format(date);
    }
}
