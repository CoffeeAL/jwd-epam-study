package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.exception.NotNumberException;
import com.loiko.alex.lesson01.exception.UnacceptableValueException;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double start = readValues(scanner, START_MESSAGE);
        double end = readValues(scanner, FINISH_MESSAGE);
        compareValues(start, end);
        double step = readValues(scanner, STEP);
        printReport(start, end, step);
    }

    private static double readValues(Scanner scanner, String message) {
        System.out.print(message);
        return checkValue(scanner);
    }

    private static void compareValues(double start, double end) {
        try {
            if (end < start) {
                throw new UnacceptableValueException("Второе число должно быть не меньше, чем первое");
            }
        } catch (UnacceptableValueException e) {
            throw new RuntimeException(e);
        }
    }

    private static double checkValue(Scanner scanner) {
        try {
            if (!scanner.hasNextDouble()) {
                throw new NotNumberException("Введено не число");
            }
            return scanner.nextDouble();
        } catch (NotNumberException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printReport(double start, double end, double step) {
        System.out.println("Угол в рад --- Тангенс угла");
        for (; start <= end; start += step) {
            System.out.println(start + " --- " + Math.tan(start));
        }
    }
}