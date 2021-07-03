package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task05Test {

    @Test(expected = NegativeValueException.class)
    public void checkNegativeNumber() throws NegativeValueException {
        Task05.isPerfectNumber(-5);
    }

    @Test
    public void checkPerfectNumber() throws NegativeValueException {
        Assert.assertTrue(Task05.isPerfectNumber(6));
    }

    @Test
    public void checkNotPerfectNumber() throws NegativeValueException {
        Assert.assertFalse(Task05.isPerfectNumber(5));
    }
}