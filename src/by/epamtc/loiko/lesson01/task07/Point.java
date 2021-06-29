package by.epamtc.loiko.lesson01.task07;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
class Point implements Serializable {

    private double x;
    private double y;

    Point() {
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point {x = " + x + ", y = " + y +"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        boolean areEqualsObjects = Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
        return areEqualsObjects;
    }

    @Override
    public int hashCode() {
        int hashCode = Double.hashCode(x);
        hashCode = 31 * hashCode + Double.hashCode(y);
        return hashCode;
    }
}