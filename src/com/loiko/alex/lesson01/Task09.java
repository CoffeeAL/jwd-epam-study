package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

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
        return InputNumberFactory.getPositiveDouble(scanner);
    }

    private static double findCircleLength(double radius) {
        return 2 * Math.PI * radius;
    }

    private static double findCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private static void printReport(double lengthCircle, double areaCircle) {
        System.out.printf("Длина окружности составляет %.4f\n", lengthCircle);
        System.out.printf("Площадь круга составляет %.4f", areaCircle);
    }
}