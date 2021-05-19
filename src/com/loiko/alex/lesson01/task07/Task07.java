package com.loiko.alex.lesson01.task07;

import com.loiko.alex.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Даны две точки: А и В. Найти, какая из точек находится ближе к началу координат
 */
public class Task07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point pointA = createPoint("A", scanner);
        Point pointB = createPoint("B", scanner);
        double aDistance = findDistance(pointA.getX(), pointA.getY());
        double bDistance = findDistance(pointB.getX(), pointB.getY());
        printReport(aDistance, bDistance);
    }

    private static Point createPoint(String namePoint, Scanner scanner) {
        double x = readInput(namePoint, scanner);
        double y = readInput(namePoint, scanner);
        return new Point(x, y);
    }

    private static double readInput(String namePoint, Scanner scanner) {
        System.out.printf("Введите координату x точки %s: ", namePoint);
        return InputNumberFactory.getDouble(scanner);
    }

    private static double findDistance(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    private static void printReport(double distanceA, double distanceB) {
        if (distanceA > distanceB) {
            System.out.printf("Точка В ближе к началу координат на %.4f", distanceA - distanceB);
        } else if (distanceA < distanceB) {
            System.out.printf("Точка А ближе к началу координат на %.4sdf", distanceB - distanceA);
        } else {
            System.out.println("Точки А и В равноудалены от начала координат");
        }
    }
}