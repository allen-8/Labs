package Java_lab2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PizzaTest {
    @Test
    public void testArea()
    {
        Pizza p = new Pizza(Size.MEDIUM, 0, 0, 0);
        assertEquals("Medium pizza", p.toString());
        Pizza p1 = new Pizza(Size.LARGE, 1, 2, 0);
        assertEquals("Large pizza with cheese (1) & pepperoni (2)", p1.toString());
        assertEquals(20, p1.calcPrice());
        PizzaOrder ord = new PizzaOrder();
        ord.add(p);
        ord.add(p1);
        assertEquals(32, ord.calcTotalPrice());
    }
}
