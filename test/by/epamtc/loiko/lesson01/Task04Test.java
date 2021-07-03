package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.NullArrayException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task04Test {

    @Before
    public void setCounterToZero() {
        Task04.setCOUNTER(0);
    }

    @Test
    public void checkIncrementWithEvenNumber() {
        Task04.checkCounterIncrement(10);
        Assert.assertTrue(Task04.getCOUNTER() == 1);
    }

    @Test
    public void checkIncrementWithOddNumber() {
        Task04.checkCounterIncrement(3);
        Assert.assertTrue(Task04.getCOUNTER() == 0);
    }

    @Test
    public void checkIncrementZero() {
        Task04.checkCounterIncrement(0);
        Assert.assertTrue(Task04.getCOUNTER() == 1);
    }

    @Test(expected = NullArrayException.class)
    public void checkNullArrayException() throws NullArrayException {
        Task04.printResultArray(null);
    }
}