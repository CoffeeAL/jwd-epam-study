package com.loiko.alex.lesson01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

import com.loiko.alex.lesson01.exception.UnacceptableValueException;
import com.loiko.alex.lesson01.util.CheckInputNumber;

import java.util.Scanner;

/**
 * Идёт n-я секунда суток. Определить, сколько прошло полных часов, минут и секунд к этому моменту
 */
public class Task06 {

    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSeconds = readInput(scanner);
        int hours = findHours(totalSeconds);
        int minutes = findMinutes(totalSeconds, hours);
        int seconds = findSeconds(totalSeconds, hours, minutes);
        printReport(hours, minutes, seconds);
    }

    private static int readInput(Scanner scanner) {
        System.out.print("Введите целое неотрицательное число: ");
        int input = checkInputValue(scanner);
        if (input == 0) {
            return 0;
        } else return input - 1;
    }

    private static int checkInputValue(Scanner scanner) {
        CheckInputNumber.checkInputInteger(scanner);
        try {
            int value = scanner.nextInt();
            if (value < 0 || value > 86400) {
                throw new UnacceptableValueException("Введено отрицательное число " +
                        "или число, превышающее количество секунд в сутках");
            } else return value;
        } catch (UnacceptableValueException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findHours(int totalSeconds) {
        return totalSeconds / SECONDS_IN_HOUR;
    }

    private static int findMinutes(int totalSeconds, int hours) {
        return (totalSeconds - hours * SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
    }

    private static int findSeconds(int totalSeconds, int hours, int minutes) {
        return totalSeconds - hours * SECONDS_IN_HOUR - minutes * SECONDS_IN_MINUTE;
    }

    private static void printReport(int hours, int minutes, int seconds) {
        System.out.print("С момента начала суток прошло " + hours + " ч., " + minutes + " м., " + seconds + " с.");
    }
}