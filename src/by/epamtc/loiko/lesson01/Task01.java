package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.util.InputNumberFactory;
import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Написать программу, позволяющую по последней цифре числа определить последнюю цифру его квадрата
 */
public class Task01 {

    public static void main(String[] args) {
        int sourceValue = inputValue();
        int lastDigitTargetValue = findTargetNumberLastDigit(sourceValue);
        printReport(lastDigitTargetValue);
    }

    public static int inputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите число: ");
        int sourceValue = InputNumberFactory.inputIntValue(scanner);
        return sourceValue;
    }

    public static int findTargetNumberLastDigit(int sourceNumber) {
        int targetNumberLastDigit = (int) Math.pow(sourceNumber, 2) % 10;
        return targetNumberLastDigit;
    }

    public static void printReport(int targetLastDigit) {
        System.out.printf("Последняя цифра квадрата числа, заканчивающегося на исходную цифру: %d", targetLastDigit);
    }
}