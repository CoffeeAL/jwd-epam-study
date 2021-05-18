package com.loiko.alex.lesson01;

import com.loiko.alex.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Идёт n-я секунда суток. Определить, сколько прошло полных часов, минут и секунд к этому моменту
 */
public class Task06 {

    private static final int SECONDS_IN_DAY = 86400;
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {
        int totalSeconds = readInput();
        int hours = findHours(totalSeconds);
        int minutes = findMinutes(totalSeconds, hours);
        int seconds = findSeconds(totalSeconds, hours, minutes);
        printReport(hours, minutes, seconds);
    }

    private static int readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое неотрицательное число: ");
        return InputNumberFactory.getLimitInt(scanner, SECONDS_IN_DAY) - 1;
    }

        private static int findHours ( int totalSeconds){
            return totalSeconds / SECONDS_IN_HOUR;
        }

        private static int findMinutes ( int totalSeconds, int hours){
            return (totalSeconds - hours * SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        }

        private static int findSeconds ( int totalSeconds, int hours, int minutes){
            return totalSeconds - hours * SECONDS_IN_HOUR - minutes * SECONDS_IN_MINUTE;
        }

        private static void printReport ( int hours, int minutes, int seconds){
            System.out.print("С момента начала суток прошло " + hours + " ч., " + minutes + " м., " + seconds + " с.");
        }
    }