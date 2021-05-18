package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

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
        getValidInterval(scanner);
        double step = readValues(scanner, STEP);
        printReport(start, end, step);
    }

    private static void getValidInterval(Scanner scanner) {
        do {
            start = readValues(scanner, START_MESSAGE);
            end = readValues(scanner, FINISH_MESSAGE);
        } while (!isValidInterval(start, end));
    }

    private static double readValues(Scanner scanner, String message) {
        System.out.print(message);
        return InputNumberFactory.getDouble(scanner);
    }

    private static boolean isValidInterval(double start, double end) {
        if (start > end) {
            System.out.println("Значение начала интервала не должно превышать значение конца интервала");
            return false;
        }
        System.out.println("Интервал успешно задан");
        return true;
    }

    private static void printReport(double start, double end, double step) {
        System.out.println("Угол в рад --- Тангенс угла");
        for (; start <= end; start += step) {
            System.out.printf(start + " --- %.4f\n", Math.tan(start));
        }
    }
}