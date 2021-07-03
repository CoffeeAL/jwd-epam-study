package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import by.epamtc.loiko.lesson01.util.InputNumberFactory;
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
        double radiusValue = readInputRadius();
        double length;
        double area;
        try {
            length = findCircleLength(radiusValue);
            area = findCircleArea(radiusValue);
            printReport(length, area);
        } catch (NegativeValueException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static double readInputRadius() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите положительное значение радиуса: ");
        double radius = InputNumberFactory.inputPositiveDoubleValue(scanner);
        return radius;
    }

    public static double findCircleLength(double radius) throws NegativeValueException {
        checkRadius(radius);
        double circleLength = 2 * Math.PI * radius;
        return circleLength;
    }

    public static double findCircleArea(double radius) throws NegativeValueException {
        checkRadius(radius);
        double circleArea = Math.PI * Math.pow(radius, 2);
        return circleArea;
    }

    public static void checkRadius(double radius) throws NegativeValueException {
        if (radius <= 0) {
            throw new NegativeValueException("Значение радиуса должно быть положительным.");
        }
    }

    public static void printReport(double lengthCircle, double areaCircle) throws NegativeValueException {
        if (lengthCircle <= 0 || areaCircle <= 0) {
            throw new NegativeValueException("Длина и площадь окружности должны принимать положительное значение.");
        }
        System.out.printf("Длина окружности составляет %.4f\n", lengthCircle);
        System.out.printf("Площадь круга составляет %.4f", areaCircle);
    }
}