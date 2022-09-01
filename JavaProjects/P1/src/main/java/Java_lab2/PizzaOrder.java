package Java_lab2;
import java.util.ArrayList;

public class PizzaOrder
{
    ArrayList<Pizza> order = new ArrayList<>();
    public void add(Pizza p) { order.add(p); }
    public int calcTotalPrice()
    {
        int total = 0;
        for (Pizza p : order)
            total += p.calcPrice();
        return total;
    }
}
