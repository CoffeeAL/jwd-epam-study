package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task10Test {

    @Test
    public void checkValidInterval() {
        boolean validInterval = Task10.isValidInterval(5.0, 8.7);
        Assert.assertTrue(validInterval);
    }

    @Test
    public void checkInvalidInterval() {
        boolean validInterval = Task10.isValidInterval(5.0, 2.7);
        Assert.assertFalse(validInterval);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeStep() throws NegativeValueException, IllegalIntervalException {
        Task10.printReport(3, 5, -5);
    }

    @Test(expected = IllegalIntervalException.class)
    public void checkStartMoreThanEnd() throws NegativeValueException, IllegalIntervalException {
        Task10.printReport(10, 5, 2);
    }
}
