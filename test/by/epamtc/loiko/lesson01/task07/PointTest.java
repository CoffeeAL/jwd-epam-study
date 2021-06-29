package by.epamtc.loiko.lesson01.task07;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class PointTest {

    @Test
    public void checkEqualPoints() {
        Point point1 = new Point(5, 6);
        Point point2 = new Point(5, 6);
        Assert.assertTrue(point1.equals(point2));
    }

    @Test
    public void checkNotEqualPoints() {
        Point point1 = new Point(5, 6);
        Point point2 = new Point(5, -6);
        Assert.assertFalse(point1.equals(point2));
    }
}