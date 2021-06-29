package by.epamtc.loiko.lesson01;

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
}
