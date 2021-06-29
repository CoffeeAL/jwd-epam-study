package by.epamtc.loiko.lesson01;

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
}