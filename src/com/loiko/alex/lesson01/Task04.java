package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.CheckInputNumber;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Составить программу, печатающую true, если указанное высказывание истинно, и false, если оно ложно
 * "Среди заданных целых чисел A, B, C, D есть хотя бы два чётных
 */
public class Task04 {

    private static int COUNTER = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        readInput(scanner);
        printReport(COUNTER);
    }

    private static void readInput(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            System.out.print("Введите целое число: ");
            CheckInputNumber.checkInputInteger(scanner);
            int value = scanner.nextInt();
            counterAction(value);
        }
    }

    private static void counterAction(int value) {
        if (value % 2 == 0) {
            COUNTER++;
        }
    }

    private static void printReport(int counter) {
        System.out.println(counter > 1);
    }
}