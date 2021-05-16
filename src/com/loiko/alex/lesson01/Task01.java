package com.loiko.alex.lesson01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

import com.loiko.alex.lesson01.exception.UnacceptableValueException;
import com.loiko.alex.lesson01.util.CheckInputNumber;

import java.util.Scanner;

/**
 * Написать программу, позволяющую по последней цифре числа определить последнюю цифру его квадрата
 */
public class Task01 {

    public static void main(String[] args) {
        int sourceValue = getInputValue();
        int lastDigitTargetValue = findTargetNumberLastDigit(sourceValue);
        printReport(lastDigitTargetValue);
    }

    private static int getInputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите цифру: ");
        CheckInputNumber.checkInputInteger(scanner);
        try {
            int input = scanner.nextInt();
            if (input < 0 || input > 9) {
                throw new UnacceptableValueException("Введено отрицательное или неоднозначное число");
            }
            return input;
        } catch (UnacceptableValueException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findTargetNumberLastDigit(int digit) {
        return (int) Math.pow(digit, 2) % 10;
    }

    private static void printReport(int result) {
        System.out.printf("Последняя цифра квадрата числа, заканчивающегося на исходную цифру, - %d", result);
    }
}