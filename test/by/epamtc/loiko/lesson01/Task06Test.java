package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task06Test {

    @Test
    public void checkHours() throws NegativeValueException {
        int hours = Task06.findHours(7500);
        Assert.assertTrue(hours == 2);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeHours() throws NegativeValueException {
        int hours = Task06.findHours(-7500);
    }

    @Test
    public void checkAmountMinutes() throws NegativeValueException, IllegalIntervalException {
        int amountMinutes = Task06.findMinutes(10000, 2);
        Assert.assertTrue(amountMinutes == 46);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeValueTotalSeconds() throws NegativeValueException, IllegalIntervalException {
        Task06.findMinutes(-6000, 1);
    }

    @Test(expected = IllegalIntervalException.class)
    public void checkIntervalForHoursAndTotalSeconds() throws IllegalIntervalException, NegativeValueException {
        Task06.findMinutes(7000, 2);
    }

    @Test
    public void checkAmountSeconds() throws IllegalIntervalException, NegativeValueException {
        int seconds = Task06.findSeconds(7230, 2, 0);
        Assert.assertTrue(seconds == 30);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeValueMinutes() throws NegativeValueException, IllegalIntervalException {
        Task06.findSeconds(6000, 1, -10);
    }

    @Test(expected = IllegalIntervalException.class)
    public void checkIntervalForHoursMinutesAndTotalSeconds() throws IllegalIntervalException, NegativeValueException {
        Task06.findSeconds(1000, 0, 17);
    }

    @Test(expected = NegativeValueException.class)
    public void checkPrintPerortWithNegativeValues() throws NegativeValueException {
        Task06.printReport(-5, 23, 53);
    }
}