package Java_lab1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTest {
    @Test
    public void TestArea()
    {
        Date d1 = new Date(31, 10, 1998);
        assertEquals("1998-10-31", d1.toString());
        d1.setMonth(81);
        assertEquals("1998-10-31", d1.toString());
        d1.setMonth(9);
        assertEquals("1998-10-31", d1.toString());
        d1.setMonth(8);
        assertEquals("1998-08-31", d1.toString());
        d1.setDay(44);
        assertEquals("1998-08-31", d1.toString());
        d1.setDay(22);
        assertEquals("1998-08-22", d1.toString());
        d1.setMonth(2); d1.setDay(29);
        assertEquals("1998-02-29", d1.toString());
        d1.setDay(30);
        assertEquals("1998-02-29", d1.toString());
        d1.setMonth(9); d1.setDay(30);
        assertEquals("1998-09-30", d1.toString());
        d1.setDay(31);
        assertEquals("1998-09-30", d1.toString());
        d1.addDay();
        assertEquals("1998-10-01", d1.toString());
    }
}
