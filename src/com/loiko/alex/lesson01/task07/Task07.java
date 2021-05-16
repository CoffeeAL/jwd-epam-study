package com.loiko.alex.lesson01.task07;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

import com.loiko.alex.lesson01.exception.UnacceptableValueException;

import java.util.Scanner;

/**
 * Даны две точки: А и В. Найти, какая из точек находится ближе к началу координат
 */
public class Task07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        readInput(scanner);
    }

    private static void readInput(Scanner scanner) {
        Point pointA = createPoint("А", scanner);
        Point pointB = createPoint("B", scanner);
        double aDistance = findDistance(pointA.getX(), pointA.getY());
        double bDistance = findDistance(pointB.getX(), pointB.getY());
        printReport(aDistance, bDistance);
    }

    private static Point createPoint(String namePoint, Scanner scanner) {
        System.out.printf("Введите координату x точки %s: ", namePoint);
        double x = checkInput(scanner);
        System.out.printf("Введите координату у точки %s: ", namePoint);
        double y = checkInput(scanner);
        return new Point(x, y);
    }

    private static double checkInput(Scanner scanner) {
        try {
            if (!scanner.hasNextInt() && !scanner.hasNextDouble()) {
                throw new UnacceptableValueException("Введена строка вместо числового значения");
            } else return scanner.nextDouble();
        } catch (UnacceptableValueException e) {
            throw new RuntimeException(e);
        }
    }

    private static double findDistance(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static void printReport(double distanceA, double distanceB) {
        if (distanceA > distanceB) {
            System.out.printf("Точка В ближе к началу координат на %f", distanceA - distanceB);
        } else if (distanceA < distanceB) {
            System.out.printf("Точка А ближе к началу координат на %f", distanceB - distanceA);
        } else {
            System.out.println("Точки А и В равноудалены от начала координат");
        }
    }
}