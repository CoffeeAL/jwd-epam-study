package com.loiko.alex.lesson01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

import com.loiko.alex.lesson01.exception.NotMonthException;
import com.loiko.alex.lesson01.exception.NotNumberException;
import com.loiko.alex.lesson01.util.CheckInputNumber;

import java.util.Scanner;

/**
 * Написать программу, позволяющую по году и номеру месяца корректно определять количество дней в этом месяце
 * (учитывая високосные годы).
 * Справочно. Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100,
 * то этот год не високосный, за исключением годов, делящихся на 400.
 */
public class Task02 {

    private static final int FEBRUARY = 28;
    private static final int FEBRUARY_LEAP = 29;
    private static final int SHORT_MONTH = 30;
    private static final int LONG_MONTH = 31;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Пожалуйста, введите год: ");
        int year = getYearValue(scanner);
        System.out.print("Пожалуйста, введите номер месяца: ");
        int month = getMonthValue(scanner);
        int amountDays = findAmountDays(year, month);
        printReport(amountDays);
    }

    private static int getYearValue(Scanner scanner) {
        CheckInputNumber.checkInputInteger(scanner);
        return scanner.nextInt();
    }

    private static int getMonthValue(Scanner scanner) {
        CheckInputNumber.checkInputInteger(scanner);
        try {
            int month = scanner.nextInt();
            if (month < 1 || month > 12) {
                throw new NotMonthException("Месяца с таким порядковым номером не существует");
            }
            return month;
        } catch (NotMonthException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findAmountDays(int year, int month) {
        if (isLongMonth(month)) {
            return LONG_MONTH;
        } else if (isShortMonth(month)) {
            return SHORT_MONTH;
        } else if (month == 2 && isLeapYear(year)) {
            return FEBRUARY_LEAP;
        } else {
            return FEBRUARY;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }

    private static boolean isLongMonth(int month) {
        return month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
    }

    private static boolean isShortMonth(int month) {
        return month == 4 || month == 6 || month == 9 || month == 11;
    }

    private static void printReport(int daysAmount) {
        System.out.printf("Количество дней в месяце: %s", daysAmount);
    }
}