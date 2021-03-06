package by.epamtc.loiko.lesson01.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class NullArrayException extends Exception {

    public NullArrayException(String message) {
        super(message);
    }

    public NullArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullArrayException(Throwable cause) {
        super(cause);
    }

    public NullArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}