package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import by.epamtc.loiko.lesson01.util.InputNumberFactory;
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
        try {
            printReport(value);
        } catch (NegativeValueException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите целое положительное число: ");
        int inputValue = InputNumberFactory.inputPositiveIntValue(scanner);
        return inputValue;
    }

    public static boolean isPerfectNumber(int value) throws NegativeValueException {
        if (value <= 0) {
            throw new NegativeValueException("Значение числа должно быть положительным.");
        }
        int sum = 0;
        for (int i = 1; i < value; i++) {
            if (value % i == 0) {
                sum += i;
            }
        }
        return sum == value;
    }

    public static void printReport(int value) throws NegativeValueException {
        System.out.println(isPerfectNumber(value));
    }
}