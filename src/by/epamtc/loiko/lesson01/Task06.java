package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import by.epamtc.loiko.lesson01.util.InputNumberFactory;
import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Идёт n-я секунда суток. Определить, сколько прошло полных часов, минут и секунд к этому моменту
 */
public class Task06 {

    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {
        int hours;
        int minutes;
        int seconds;
        try {
            int totalSeconds = readInput();
            hours = findHours(totalSeconds);
            minutes = findMinutes(totalSeconds, hours);
            seconds = findSeconds(totalSeconds, hours, minutes);
            printReport(hours, minutes, seconds);
        } catch (NegativeValueException | IllegalIntervalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int readInput() throws NegativeValueException, IllegalIntervalException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое неотрицательное число: ");
        int seconds = InputNumberFactory.inputLimitedIntValue(scanner, SECONDS_IN_DAY) - 1;
        return seconds;
    }

    public static int findHours(int totalSeconds) throws NegativeValueException {
        if (totalSeconds < 0) {
            throw new NegativeValueException("Количество секунд должно быть положительным числом.");
        }
        int hours = totalSeconds / SECONDS_IN_HOUR;
        return hours;
    }

    public static int findMinutes(int totalSeconds, int hours) throws NegativeValueException, IllegalIntervalException {
        if (totalSeconds < 0 || hours < 0) {
            throw new NegativeValueException("Количество секунд должно быть положительным числом, а количество полных " +
                                             "часов - неотрицательным.");
        }
        if (totalSeconds < hours * SECONDS_IN_HOUR) {
            throw new IllegalIntervalException("Общее количество секунд не может быть меньше количества секунд в " +
                                               "полностью прошедших часах.");
        }
        int minutes = (totalSeconds - hours * SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        return minutes;
    }

    public static int findSeconds(int totalSeconds, int hours, int minutes)
            throws NegativeValueException, IllegalIntervalException {
        if (totalSeconds < 0 || hours < 0 || minutes < 0) {
            throw new NegativeValueException("Количество секунд должно быть положительным числом, а количество полных " +
                                             "часов и полных минут - неотрицательным.");
        }
        if (totalSeconds < (hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE)) {
            throw new IllegalIntervalException("Общее количество секунд не может быть меньше количества секунд в " +
                                               "полностью прошедших часах и минутах.");
        }
        int seconds = totalSeconds - hours * SECONDS_IN_HOUR - minutes * SECONDS_IN_MINUTE;
        return seconds;
    }

    public static void printReport(int hours, int minutes, int seconds) throws NegativeValueException {
        if (hours < 0 || minutes < 0 || seconds < 0) {
            throw new NegativeValueException("Количество часов, минут и секунд не может быть отрицательным.");
        }
        System.out.print("С момента начала суток прошло " + hours + " ч., " + minutes + " м., " + seconds + " с.");
    }
}