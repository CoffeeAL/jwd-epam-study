package by.epamtc.loiko.lesson01;

import by.epamtc.loiko.lesson01.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson01.exception.NegativeValueException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Test03Test {

    @Test
    public void checkRadius() throws NegativeValueException {
        double radius = Task03.findRadius(16.0);
        Assert.assertTrue(radius == 2);
    }

    @Test(expected = NegativeValueException.class)
    public void checkIllegalRadius() throws NegativeValueException {
        double radius = Task03.findRadius(-16.0);
    }

    @Test
    public void checkFindArea() throws NegativeValueException {
        double radius = Task03.findSmallSquareArea(4.0);
        Assert.assertTrue(radius == 32);
    }

    @Test(expected = NegativeValueException.class)
    public void checkIllegalRadiusForFindSmallSquareArea() throws NegativeValueException {
        double radius = Task03.findSmallSquareArea(-16.0);
    }

    @Test(expected = NegativeValueException.class)
    public void checkReportForNegativeValueSquareArea() throws IllegalIntervalException, NegativeValueException {
        Task03.printReport(-4.0, 2.0);
    }

    @Test(expected = IllegalIntervalException.class)
    public void checkReportForBiggerValueForSmallSquareArea() throws IllegalIntervalException, NegativeValueException {
        Task03.printReport(4.0, 8.0);
    }
}