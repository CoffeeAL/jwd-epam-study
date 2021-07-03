package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import by.epamtc.loiko.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Окружность вписана в квадрат заданной площади. Найти площадь квадрата, вписанного в эту окружность.
 * Во сколько раз площадь вписанного квадрата меньше площади заданного квадрата?
 */
public class Task03 {

    public static void main(String[] args) {
        double bigSquareArea = readInputValue();
        try {
            double radius = findRadius(bigSquareArea);
            double smallSquareArea = findSmallSquareArea(radius);
            printReport(bigSquareArea, smallSquareArea);
        } catch (NegativeValueException | IllegalIntervalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static double readInputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите площадь внешнего квадрата: ");
        double area = InputNumberFactory.inputPositiveDoubleValue(scanner);
        return area;
    }

    public static double findRadius(double area) throws NegativeValueException {
        if (area <= 0) {
            throw new NegativeValueException("Площадь квадрата должна быть положительным числом.");
        }
        double radius = Math.sqrt(area) / 2;
        return radius;
    }

    public static double findSmallSquareArea(double radius) throws NegativeValueException {
        if (radius <= 0) {
            throw new NegativeValueException("Радиус должен быть положительным числом.");
        }
        double smallSquareArea = 2 * Math.pow(radius, 2);
        return smallSquareArea;
    }

    public static void printReport(double bigSquareArea, double smallSquareArea) throws NegativeValueException,
            IllegalIntervalException {
        if (bigSquareArea <= 0 || smallSquareArea <= 0) {
            throw new NegativeValueException("Площадь внешнего и внутреннего квадрата должна принимать положительное " +
                                             "значение.");
        }
        if (smallSquareArea > bigSquareArea) {
            throw new IllegalIntervalException("Площадь большего квадрата не должна быть меньше площадь меньшего " +
                                               "квадрата.");
        }
        System.out.printf("Площадь квадрата, вписанного в окружность, составляет %.4f\n", smallSquareArea);
        System.out.printf("Площадь внешнего квадрата больше площади внутреннего квадрата в %.0f раза\n",
                          bigSquareArea / smallSquareArea);
    }
}