package Java_lab4;
import java.util.ArrayList;
import java.util.List;
public class Rectangle implements Figure
{
    private List<Point>points = new ArrayList<>();
    Rectangle(List<Point>p) { points = p; }
    private double getLength(Point p0, Point p1)
    {
        return Math.sqrt(Math.pow(p1.getX() - p0.getX(), 2) + Math.pow(p1.getY() - p0.getY(), 2));
    }
    @Override
    public double getLength()
    {
        Point p0 = points.get(0);
        Point p1 = points.get(1);
        Point p2 = points.get(2);
        Point p3 = points.get(3);
        return getLength(p0, p1 ) + getLength(p1, p2) + getLength(p2, p3) + getLength(p3, p0);
    }
    @Override
    public String toString() { return "Rectangle {" + "points = " + points + '}'; }
}
