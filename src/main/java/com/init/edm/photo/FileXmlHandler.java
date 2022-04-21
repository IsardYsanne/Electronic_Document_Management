package com.init.edm.photo;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.io.File;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Фрматирует файл в пользовательский формат при анмаршалинге.
 *
 * @author GKordyukova
 */
public class FileXmlHandler extends XmlAdapter<String, File> {

    /**
     * Преобразовывать файл при анмаршалинге.
     *
     * @param path путь, по которому находится файл
     * @return {@link File} файл после анмаршалинга
     * @throws Exception проверенное исключение
     */
    @Override
    public File unmarshal(String path) throws Exception {
        return Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).toURI()).toFile();
    }

    /**
     * Преобразовывать файл в строковый тип.
     *
     * @param file путь, по которому находится файл
     * @return путь в строковом формате
     */
    @Override
    public String marshal(File file) {
        return file.getName();
    }
}
