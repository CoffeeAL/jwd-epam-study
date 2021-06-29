package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalYearMonthNumberException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task02Test {

    @Test
    public void checkFindAmountDays() throws IllegalYearMonthNumberException {
        int octoberAmountDays = Task02.findAmountDays(1988, 10);
        Assert.assertTrue(octoberAmountDays == 31);
    }

    @Test
    public void checkFebruaryLeapAmountDays() throws IllegalYearMonthNumberException {
        int octoberAmountDays = Task02.findAmountDays(2000, 2);
        Assert.assertTrue(octoberAmountDays == 29);
    }

    @Test(expected = IllegalYearMonthNumberException.class)
    public void checkIllegalMonth() throws IllegalYearMonthNumberException {
        Task02.findAmountDays(1970, -5);
    }

    @Test(expected = IllegalYearMonthNumberException.class)
    public void checkAmountMonthDaysInIllegalYear() throws IllegalYearMonthNumberException {
        Task02.findAmountDays(-1970, 5);
    }

    @Test
    public void checkLeapYear() throws IllegalYearMonthNumberException {
        boolean leapYear = Task02.isLeapYear(2004);
        Assert.assertTrue(leapYear);
    }

    @Test
    public void checkNotLeapYear() throws IllegalYearMonthNumberException {
        boolean leapYear = Task02.isLeapYear(1700);
        Assert.assertFalse(leapYear);
    }

    @Test(expected = IllegalYearMonthNumberException.class)
    public void checkIllegalYear() throws IllegalYearMonthNumberException {
        Task02.isLeapYear(-2005);
    }
}