package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task09Test {

    @Test
    public void checkRadius() throws NegativeValueException {
        Task09.checkRadius(9);
    }

    @Test(expected = NegativeValueException.class)
    public void checkIllegalRadius() throws NegativeValueException {
        Task09.checkRadius(-9);
    }

    @Test
    public void checkCircleLength() throws NegativeValueException {
        double length = Task09.findCircleLength(5);
        double scale = Math.pow(10, 3);
        double result = Math.ceil(length * scale) / scale;
        Assert.assertTrue(result == 31.416);
    }

    @Test
    public void checkCircleArea() throws NegativeValueException {
        double area = Task09.findCircleArea(5);
        double scale = Math.pow(10, 3);
        double result = Math.ceil(area * scale) / scale;
        Assert.assertTrue(result == 78.54);
    }

    @Test(expected = NegativeValueException.class)
    public void checkReport() throws NegativeValueException {
        Task09.printReport(-5, 6);
    }
}