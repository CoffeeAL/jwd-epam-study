package com.loiko.alex.lesson01.util;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public final class InputNumberFactory {

    private InputNumberFactory() {
    }

    public static int getInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Введена строка или вещественное число. Пожалуйста, введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int getPositiveInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Введена строка или вещественное число. Пожалуйста, введите целое положительное число: ");
            scanner.next();
        }
        int value = getInt(scanner);
        if (value <= 0) {
            System.out.print("Число должно быть больше положительным. Попробуйте ещё раз: ");
            value = getPositiveInt(scanner);
        }
        return value;
    }

    public static int getLimitInt(Scanner scanner, int limit) {
        int value = getInt(scanner);
        if (value <= 0 || value > limit) {
            System.out.printf("Число должно быть положительным и не превышать предел %d. Попробуйте ещё раз: ",
                    limit);
            value = getLimitInt(scanner, limit);
        }
        return value;
    }

    public static int getLimitInt(Scanner scanner, int lowerLimit, int upperLimit) {
        int value = getInt(scanner);
        if (value < lowerLimit || value > upperLimit) {
            System.out.printf("Число должно быть не меньше %d и не больше %d. Попробуйте ещё раз: ",
                    lowerLimit, upperLimit);
            value = getLimitInt(scanner, lowerLimit, upperLimit);
        }
        return value;
    }

    public static double getDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Введена строка. Пожалуйста, введите число: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static double getPositiveDouble(Scanner scanner) {
        double value = getDouble(scanner);
        if (value <= 0) {
            System.out.print("Число должно быть положительным. Попробуйте ещё раз: ");
            value = getPositiveDouble(scanner);
        }
        return value;
    }
}