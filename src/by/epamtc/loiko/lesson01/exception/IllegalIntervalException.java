package by.epamtc.loiko.lesson01.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class IllegalIntervalException extends Exception {

    public IllegalIntervalException(String message) {
        super(message);
    }

    public IllegalIntervalException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalIntervalException(Throwable cause) {
        super(cause);
    }

    public IllegalIntervalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}