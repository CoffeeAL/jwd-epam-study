package by.epamtc.loiko.lesson01;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Task08Test {

    @Test
    public void checkCalculateFunctionSmallXValue() {
        double value = Task08.calculateFunctionSmallXValue(0);
        double scale = Math.pow(10, 3);
        double result = Math.ceil(value * scale) / scale;
        Assert.assertTrue(result == -0.166);
    }

    @Test
    public void checkCalculateFunctionLargeXValue() {
        double value = Task08.calculateFunctionLargeXValue(5);
        Assert.assertTrue(value == -1);
    }
}