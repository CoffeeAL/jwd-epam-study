package by.epamtc.loiko.lesson01.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class NegativeValueException extends Exception {

    public NegativeValueException(String message) {
        super(message);
    }

    public NegativeValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeValueException(Throwable cause) {
        super(cause);
    }

    public NegativeValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}