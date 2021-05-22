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
 * Вычислить значение функции F(x) на отрезке [a, b] с шагом h. Результат представить в виде таблицы,
 * первый столбец которой - значения аргумента, второй - соответствующие значения функции.
 * F(x) = tg(x)
 */
public class Task10 {

    private static final String START_MESSAGE = "Введите начало интервала: ";
    private static final String FINISH_MESSAGE = "Введите конец интервала: ";
    private static final String STEP = "Введите шаг: ";
    private static double start;
    private static double end;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputValidInterval(scanner);
        double step = readValues(scanner, STEP);
        try {
            printReport(start, end, step);
        } catch (NegativeValueException | IllegalIntervalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void inputValidInterval(Scanner scanner) {
        do {
            start = readValues(scanner, START_MESSAGE);
            end = readValues(scanner, FINISH_MESSAGE);
        } while (!isValidInterval(start, end));
    }

    public static double readValues(Scanner scanner, String message) {
        System.out.print(message);
        return InputNumberFactory.inputDoubleValue(scanner);
    }

    public static boolean isValidInterval(double start, double end) {
        if (start > end) {
            System.out.println("Значение начала интервала не должно превышать значение конца интервала");
            return false;
        }
        System.out.println("Интервал успешно задан");
        return true;
    }

    public static void printReport(double start, double end, double step)
            throws NegativeValueException, IllegalIntervalException {
        if (step <= 0) {
            throw new NegativeValueException("Шаг должен быть положительным числом.");
        }
        if (start > end) {
            throw new IllegalIntervalException("Значение начала интервала не должно превышать значение конца интервала.");
        }
        System.out.println("Угол в рад --- Тангенс угла");
        for (; start <= end; start += step) {
            System.out.printf("%.4f --- %.4f\n", start, Math.tan(start));
        }
    }
}