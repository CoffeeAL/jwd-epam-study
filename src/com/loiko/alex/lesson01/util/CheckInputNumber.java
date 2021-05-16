package com.loiko.alex.lesson01.util;

import com.loiko.alex.lesson01.exception.NotNumberException;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public final class CheckInputNumber {

    private CheckInputNumber() {
    }

    public static void checkInputInteger(Scanner scanner) {
        try {
            if (!scanner.hasNextInt()) {
                throw new NotNumberException("Введена строка или вещественное число");
            }
        } catch (NotNumberException e) {
            throw new RuntimeException(e);
        }
    }
}