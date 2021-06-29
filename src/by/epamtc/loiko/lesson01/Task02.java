package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.IllegalYearMonthNumberException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import by.epamtc.loiko.lesson01.util.InputNumberFactory;

import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Написать программу, позволяющую по году и номеру месяца корректно определять количество дней в этом месяце
 * (учитывая високосные годы).
 * Справочно. Год считается високосным, если он делится без остатка на 4. Однако, если год также делится на 100,
 * то этот год не високосный, за исключением годов, делящихся на 400.
 */
public class Task02 {

    private static final int FIRST_MONTH_NUMBER = 1;
    private static final int LAST_MONTH_NUMBER = 12;
    private static final int[] AMOUNT_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int DAYS_IN_FEBRUARY_LEAP = 29;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = inputYearValue(scanner);
        int month;
        int amountDays;
        try {
            month = inputMonthValue(scanner);
            amountDays = findAmountDays(year, month);
            printReport(amountDays);
        } catch (IllegalYearMonthNumberException | NegativeValueException | IllegalIntervalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int inputYearValue(Scanner scanner) {
        System.out.print("Пожалуйста, введите год: ");
        int year = InputNumberFactory.inputPositiveIntValue(scanner);
        return year;
    }

    public static int inputMonthValue(Scanner scanner) throws NegativeValueException, IllegalIntervalException {
        System.out.print("Пожалуйста, введите номер месяца: ");
        int month = InputNumberFactory.inputLimitedIntValue(scanner, FIRST_MONTH_NUMBER, LAST_MONTH_NUMBER);
        return month;
    }

    public static int findAmountDays(int year, int month) throws IllegalYearMonthNumberException {
        if (year <= 0 || month <= 0 || month > 12) {
            throw new IllegalYearMonthNumberException("Некорректное значение года или месяца.");
        }
        if (isLeapYear(year) && month == 2) {
            return DAYS_IN_FEBRUARY_LEAP;
        }
        return AMOUNT_DAYS[month - 1];
    }

    public static boolean isLeapYear(int year) throws IllegalYearMonthNumberException {
        if (year <= 0) {
            throw new IllegalYearMonthNumberException("Год должен принимать положительное значение.");
        }
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public static void printReport(int daysAmount) throws IllegalIntervalException {
        if (daysAmount < 1 || daysAmount > 31) {
            throw new IllegalIntervalException("Ни в каком месяце не может быть такого количества дней.");
        }
        System.out.printf("Количество дней в месяце: %s", daysAmount);
    }
}