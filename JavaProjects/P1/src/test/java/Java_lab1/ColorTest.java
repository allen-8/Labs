package Java_lab1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ColorTest
{
    @Test
    public void TestArea()
    {
        Color c = new Color(156, 32, 211);
        assertEquals(282, c.hue());
        assertEquals(48, c.lightness());
        assertEquals(74, c.saturation());
    }
}
