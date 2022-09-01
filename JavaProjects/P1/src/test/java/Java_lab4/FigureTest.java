package Java_lab4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
public class FigureTest {
    @Test
    public void testArea()
    {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 0);
        Point p3 = new Point(4, 2);
        Point p4 = new Point(0, 2);
        Point p5 = new Point(-1, 2);
        Point p6 = new Point(-1, 0);
        List<Point>p = new ArrayList<>();
        p.add(p1); p.add(p2); p.add(p3); p.add(p4);
        Rectangle r1 = new Rectangle(p);
        assertEquals(12, r1.getLength(), 0.0);
        PolyLine pl1 = new PolyLine(p);
        assertEquals(12, pl1.getLength(), 0.0);
        p.add(p5); p.add(p6);
        assertEquals(14, pl1.getLength(), 0.0);
    }
}
