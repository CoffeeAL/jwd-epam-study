package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Составить программу, печатающую true, если указанное высказывание истинно, и false, если оно ложно
 * Является ли целое число совершенным
 * Справочно: Совершенное число — натуральное число, равное сумме всех своих собственных делителей,
 * отличных от самого́ числа (например, 6 = 1 + 2 + 3)
 */
public class Task05 {

    public static void main(String[] args) {
        int value = readInput();
        printReport(value);
    }

    private static int readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите целое положительное число: ");
        return InputNumberFactory.getPositiveInt(scanner);
    }

    private static boolean isAssertionTrue(int value) {
        int sum = 0;
        for (int i = 1; i < value; i++) {
            if (value % i == 0) {
                sum += i;
            }
        }
        return sum == value;
    }

    private static void printReport(int value) {
        System.out.println(isAssertionTrue(value));
    }
}