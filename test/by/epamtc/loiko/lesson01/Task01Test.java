package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

public class Task01Test {

    @Test
    public void checkFindTargetLastDigit() {
        int value = Task01.findTargetNumberLastDigit(17);
        Assert.assertTrue(value == 9);
    }

    @Test(expected = IllegalIntervalException.class)
    public void checkPrintReport() throws IllegalIntervalException {
        Task01.printReport(17);
    }
}