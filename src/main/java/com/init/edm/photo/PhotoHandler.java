package com.init.edm.photo;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Обработчик для фотографии.
 *
 * @author GKordyukova
 */
public interface PhotoHandler {

    /**
     * Преобразовать имя фото в файл.
     *
     * @param fileName название фото
     * @return {@link File} преобразованное название в файл
     */
    File convertNameToFile(String fileName) throws URISyntaxException;

    /**
     * Декодировать фото строчного типа в файл
     *
     * @param photoString закодированная строка
     * @param name название файла
     * @return {@link File} преобразованное фото в файл
     */
    File convertToFile(String photoString, String name) throws URISyntaxException, IOException;
}
