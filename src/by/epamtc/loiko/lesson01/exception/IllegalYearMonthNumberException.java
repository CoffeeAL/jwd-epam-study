package by.epamtc.loiko.lesson01.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class IllegalYearMonthNumberException extends Exception {

    public IllegalYearMonthNumberException(String message) {
        super(message);
    }

    public IllegalYearMonthNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalYearMonthNumberException(Throwable cause) {
        super(cause);
    }

    public IllegalYearMonthNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}