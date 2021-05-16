package com.loiko.alex.lesson01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

import com.loiko.alex.lesson01.exception.UnacceptableValueException;

import java.util.Scanner;

/**
 * Найти длину окружности и площадь круга по заданному радиусу
 */
public class Task09 {

    public static void main(String[] args) {
        double radiusValue = readInput();
        double length = findCircleLength(radiusValue);
        double area = findCircleArea(radiusValue);
        printReport(length, area);
    }

    private static double readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите положительное значение радиуса: ");
        return checkValue(scanner);
    }

    private static double checkValue(Scanner scanner) {
        try {
            if(!scanner.hasNextDouble()) {
                throw new UnacceptableValueException("Введена строка вместо числового значения");
            }
            double value = scanner.nextDouble();
            if (value <= 0) {
                throw new UnacceptableValueException("Введено неположительное значение радиуса");
            } return value;
        } catch (UnacceptableValueException e) {
            throw new RuntimeException(e);
        }
    }

    private static double findCircleLength(double radius) {
        return 2 * Math.PI * radius;
    }

    private static double findCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static void printReport(double lengthCircle, double areaCircle) {
        System.out.printf("Длина окружности составляет %f\n", lengthCircle);
        System.out.printf("Площадь круга составляет %f", areaCircle);
    }
}