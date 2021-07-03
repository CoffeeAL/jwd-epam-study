package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.NullArrayException;
import by.epamtc.loiko.lesson01.util.InputNumberFactory;

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
    private static int AMOUNT_NUMBERS = 4;

    public static void main(String[] args) {
        int[] values = readInput();
        try {
            printResultArray(values);
        } catch (NullArrayException e) {
            throw new RuntimeException(e.getMessage());
        }
        printReport(COUNTER);
    }

    public static int[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[AMOUNT_NUMBERS];
        for (int i = 0; i < values.length; i++) {
            System.out.print("Введите целое число: ");
            values[i] = InputNumberFactory.inputIntValue(scanner);
            checkCounterIncrement(values[i]);
        }
        return values;
    }

    public static void checkCounterIncrement(int value) {
        if (value % 2 == 0) {
            COUNTER++;
        }
    }

    public static void printResultArray(int[] array) throws NullArrayException {
        if (array == null) {
            throw new NullArrayException("Массив отсутствует.");
        }
        /*с использованиеем класса java.util.Arrays
        System.out.println("Полученный массив целых чисел: " + Arrays.toString(array));*/
        System.out.print("Полученный массив целых чисел: ");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.printf("{%s, ", array[i]);
            } else if (i == array.length - 1) {
                System.out.printf("%s}\n", array[i]);
            } else {
                System.out.printf("%s, ", array[i]);
            }
        }
    }

    public static void printReport(int counter) {
        System.out.print(counter > 1);
    }

    /**
     * for JUnit-tests
     */
    public static int getCOUNTER() {
        return COUNTER;
    }

    public static void setCOUNTER(int value) {
        COUNTER = value;
    }
}