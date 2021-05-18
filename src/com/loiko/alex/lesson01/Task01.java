package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Написать программу, позволяющую по последней цифре числа определить последнюю цифру его квадрата
 */
public class Task01 {

    private static final int MIN_DIGIT = 0;
    private static final int MAX_DIGIT = 9;

    public static void main(String[] args) {
        int sourceValue = getInputValue();
        int lastDigitTargetValue = findTargetNumberLastDigit(sourceValue);
        printReport(lastDigitTargetValue);
    }

    private static int getInputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите цифру: ");
        return InputNumberFactory.getLimitInt(scanner, MIN_DIGIT, MAX_DIGIT);
    }

    private static int findTargetNumberLastDigit(int digit) {
        return (int) Math.pow(digit, 2) % 10;
    }

    private static void printReport(int result) {
        System.out.printf("Последняя цифра квадрата числа, заканчивающегося на исходную цифру: %d", result);
    }
}