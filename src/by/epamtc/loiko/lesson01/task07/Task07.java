package by.epamtc.loiko.lesson01.task07;

import by.epamtc.loiko.lesson01.util.InputNumberFactory;
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
        double aDistance = Math.hypot(pointA.getX(), pointA.getY());
        double bDistance = Math.hypot(pointB.getX(), pointB.getY());
        printReport(aDistance, bDistance);
    }

    public static Point createPoint(String namePoint, Scanner scanner) {
        double x = readInputX(namePoint, scanner);
        double y = readInputY(namePoint, scanner);
        Point point = new Point(x, y);
        return point;
    }

    public static double readInputX(String namePoint, Scanner scanner) {
        System.out.printf("Введите координату x точки %s: ", namePoint);
        double xValue = InputNumberFactory.inputDoubleValue(scanner);
        return xValue;
    }

    public static double readInputY(String namePoint, Scanner scanner) {
        System.out.printf("Введите координату y точки %s: ", namePoint);
        double yValue = InputNumberFactory.inputDoubleValue(scanner);
        return yValue;
    }

    public static void printReport(double distanceA, double distanceB) {
        if (distanceA > distanceB) {
            System.out.printf("Точка В ближе к началу координат на %.4f", distanceA - distanceB);
        } else if (distanceA < distanceB) {
            System.out.printf("Точка А ближе к началу координат на %.4f", distanceB - distanceA);
        } else {
            System.out.print("Точки А и В равноудалены от начала координат");
        }
    }
}