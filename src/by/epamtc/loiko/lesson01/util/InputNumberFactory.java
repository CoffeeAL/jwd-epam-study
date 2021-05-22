package by.epamtc.loiko.lesson01.util;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public final class InputNumberFactory {

    private InputNumberFactory() {
    }

    public static int inputIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Введена строка или вещественное число. Пожалуйста, введите целое число: ");
            scanner.next();
        }
        int inputValue = scanner.nextInt();
        return inputValue;
    }

    public static int inputPositiveIntValue(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Введена строка или вещественное число. Пожалуйста, введите целое положительное число: ");
            scanner.next();
        }
        int inputValue = scanner.nextInt();
        if (inputValue <= 0) {
            System.out.print("Число должно быть больше положительным. Попробуйте ещё раз: ");
            inputValue = inputPositiveIntValue(scanner);
        }
        return inputValue;
    }

    public static int inputLimitedIntValue(Scanner scanner, int upperLimit) throws NegativeValueException {
        if (upperLimit < 0) {
            throw new NegativeValueException("Устанавливаемый предел не может принимать отрицательное значение.");
        }
        int inputValue = inputPositiveIntValue(scanner);
        if (inputValue > upperLimit) {
            System.out.printf("Число не должно превышать предел %d. Попробуйте ещё раз: ", upperLimit);
            inputValue = inputLimitedIntValue(scanner, upperLimit);
        }
        return inputValue;
    }

    public static int inputLimitedIntValue(Scanner scanner, int lowerLimit, int upperLimit)
            throws NegativeValueException, IllegalIntervalException {
        if (lowerLimit < 0 || upperLimit < 0) {
            throw new NegativeValueException("Устанавливаемые пределы не могут принимать отрицательные значения.");
        }
        if (lowerLimit > upperLimit) {
            throw new IllegalIntervalException("Нижний предел не может превышать верхний предел.");
        }
        int value = inputIntValue(scanner);
        if (value < lowerLimit || value > upperLimit) {
            System.out.printf("Число должно быть не меньше %d и не больше %d. Попробуйте ещё раз: ",
                              lowerLimit, upperLimit);
            value = inputLimitedIntValue(scanner, lowerLimit, upperLimit);
        }
        return value;
    }

    public static double inputDoubleValue(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Введена строка. Пожалуйста, введите число: ");
            scanner.next();
        }
        double inputValue = scanner.nextDouble();
        return inputValue;
    }

    public static double inputPositiveDoubleValue(Scanner scanner) {
        double inputValue = inputDoubleValue(scanner);
        if (inputValue <= 0) {
            System.out.print("Число должно быть положительным. Попробуйте ещё раз: ");
            inputValue = inputPositiveDoubleValue(scanner);
        }
        return inputValue;
    }
}