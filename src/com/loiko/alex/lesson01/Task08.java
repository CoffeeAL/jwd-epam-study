package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Вычислить значение функции
 * 1 / (x^3 - 6), если x < 3
 * -x^2 + 3x + 9, если x >= 3
 */
public class Task08 {

    private static final String FUNCTION_VALUE = "Значение функции %.4f ";

    public static void main(String[] args) {
        double value = readValue();
        printReport(value);
    }

    private static double readValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x: ");
        return InputNumberFactory.getDouble(scanner);
    }

    private static double calculateFunctionSmallXValue(double xValue) {
        return 1 / (Math.pow(xValue, 3) - 6);
    }

    private static double calculateFunctionLargeXValue(double xValue) {
        return -Math.pow(xValue, 2) + 3 * xValue + 9;
    }

    private static void printReport(double value) {
        System.out.printf(FUNCTION_VALUE, value < 3
                ? calculateFunctionSmallXValue(value)
                : calculateFunctionLargeXValue(value));
    }
}