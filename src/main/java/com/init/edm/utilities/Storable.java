package com.init.edm.utilities;

import java.util.UUID;

/**
 * Предназначен для сохранения документов.
 *
 * @author GKordyukova
 */
public interface Storable {

    /**
     * Получить идентификатор документа
     *
     * @return {@link UUID}
     */
    UUID getUuid();

    /**
     * Получить наименование хранилища (таблицы)
     *
     * @return {@link String}
     */
    String getName();
}
