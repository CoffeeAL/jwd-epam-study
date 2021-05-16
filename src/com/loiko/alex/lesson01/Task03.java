package com.loiko.alex.lesson01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

import com.loiko.alex.lesson01.exception.UnacceptableValueException;

import java.util.Scanner;

/**
 * Окружность вписана в квадрат заданной площади. Найти площадь квадрата, вписанного в эту окружность.
 * Во сколько раз площадь вписанного квадрата меньше площади заданного квадрата?
 */
public class Task03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите площадь внешнего квадрата: ");
        double bigSquareArea = getBigSquareValue(scanner);
        double radius = findRadius(bigSquareArea);
        double smallSquareArea = findSmallSquareArea(radius);
        printReport(bigSquareArea, smallSquareArea);
    }

    private static double getBigSquareValue(Scanner scanner) {
        try {
            if (!isValidValue(scanner)) {
                throw new UnacceptableValueException("Введена строка вместо числа");
            }
            return scanner.nextDouble();
        } catch (UnacceptableValueException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isValidValue(Scanner scanner) {
        return (scanner.hasNextInt() || scanner.hasNextDouble()) && scanner.nextDouble() > 0;
    }

    private static double findRadius(double area) {
        return Math.sqrt(area) / 2;
    }

    private static double findSmallSquareArea(double radius) {
        return 2 * Math.pow(radius, 2);
    }

    private static void printReport(double bigSquareArea, double smallSquareArea) {
        System.out.printf("Площадь квадрата, вписанного в окружность, составляет %f\n", smallSquareArea);
        System.out.printf("Площадь большого квадрата больше площади меньшего квадрата в %f раз", bigSquareArea / smallSquareArea);
    }
}