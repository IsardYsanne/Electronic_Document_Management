package com.init.edm.photo;

import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;

/**
 * Служит для преобразования имя фото в файл для UI.
 *
 * @author GKordyukova
 */
@Component
public class PhotoHandlerImpl implements PhotoHandler {

    /**
     * Преобразовать имя фото в файл.
     *
     * @param fileName название фото
     * @return {@link File} преобразованное название в файл
     */
    @Override
    public File convertNameToFile(String fileName) throws URISyntaxException {
        return Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("avatar/" + fileName)).toURI()).toFile();
    }

    /**
     * Декодировать фото строчного типа в файл
     *
     * @param photoString закодированная строка
     * @param name название файла
     * @return {@link File} преобразованное фото в файл
     */
    @Override
    public File convertToFile(String photoString, String name) throws URISyntaxException, IOException {
        File resources = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("avatar/")).toURI());
        File file = new File(resources, name + ".jpg");
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
        stream.write(Base64.getDecoder().decode(photoString));
        stream.flush();
        return file;
    }
}
