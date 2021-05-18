package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

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
        double radius = findRadius(bigSquareArea);
        double smallSquareArea = findSmallSquareArea(radius);
        printReport(bigSquareArea, smallSquareArea);
    }

    private static double readInputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите площадь внешнего квадрата: ");
        return InputNumberFactory.getPositiveDouble(scanner);
    }

    private static double findRadius(double area) {
        return Math.sqrt(area) / 2;
    }

    private static double findSmallSquareArea(double radius) {
        return 2 * Math.pow(radius, 2);
    }

    private static void printReport(double bigSquareArea, double smallSquareArea) {
        System.out.printf("Площадь квадрата, вписанного в окружность, составляет %.4f\n", smallSquareArea);
        /*площадь вписанного в окружность квадрата всегда в 2 раза меньше площади квадрата,
        описанного вокруг той же окружности*/
        System.out.printf("Площадь внешнего квадрата больше площади внутреннего квадрата в %.0f раза",
                bigSquareArea / smallSquareArea);
    }
}