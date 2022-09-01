package Java_lab4;

import java.util.ArrayList;
import java.util.List;

public class PolyLine implements Figure
{
    private List<Point> points = new ArrayList<>();
    PolyLine(List<Point>p) { points = p; }
    private double getLength(Point p0, Point p1)
    {
        return Math.sqrt(Math.pow(p1.getX()-p0.getX(), 2) + Math.pow(p1.getY()-p0.getY(), 2));
    }
    @Override
    public double getLength()
    {
        double len = 0;
        for (int i = 0; i < points.size() - 1; ++i)
            len += getLength(points.get(i), points.get(i + 1));
        len += getLength(points.get(points.size() - 1), points.get(0));
        return len;
    }
    @Override
    public String toString() { return "PolyLine {" + "points = " + points + '}'; }
    public void appendPoint(Point p) { points.add(p); }
}
