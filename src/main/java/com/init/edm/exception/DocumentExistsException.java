package com.init.edm.exception;

/**
 * В случае, если документ с генерируемым номером уже существует, "выбрасывается" исключение.
 *
 * @author GKordyukova
 */
public class DocumentExistsException extends RuntimeException {

    /**
     * @param message сообщение об ошибке
     */
    public DocumentExistsException(String message) {
        super(message);
    }
}
