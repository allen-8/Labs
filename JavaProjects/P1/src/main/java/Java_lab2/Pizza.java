package Java_lab2;

public class Pizza
{
    private Size size;
    private int cheese , pepperoni, ham;
    Pizza(Size s, int c, int p, int h)
    {
        size = s;
        cheese = Math.max(c, 0);
        pepperoni = Math.max(p, 0);
        ham = Math.max(h, 0);
        if (c < 0 || p < 0 || h < 0)
            System.out.println("Errors in request was found. All invalid parameters was replaced to '0'");
    }
    public Size getSize() { return size; }
    public int getCheese() { return cheese; }
    public int getPepperoni() { return pepperoni; }
    public int getHam() { return ham; }
    public void setSize(Size s) { size = s; }
    private int setter(int v, String s)
    {
        if (v < 0)
            System.out.println("Invalid request; " + s + " set as '0'");
        return Math.max(v, 0);
    }
    public void setCheese(int c) { cheese = setter(c, "cheese"); }
    public void setPepperoni(int p) { pepperoni = setter(p, "pepperoni"); }
    public void setHam(int h) { ham = setter(h, "ham"); }
    @Override
    public String toString()
    {
        String str = size.getName() + " pizza";
        if (cheese == 0 && pepperoni == 0 && ham == 0)
            return str;
        str += " with ";
        if (cheese > 0)
            str = str + "cheese (" + cheese + ") & ";
        if (pepperoni > 0)
            str = str + "pepperoni (" + pepperoni + ") & ";
        if (ham > 0)
            str = str + "ham (" + ham + ") & ";
        str = str.substring(0, str.length() - 3);
        return str;
    }
    public int calcPrice()
    {
        int s = 0;
        switch(size)
        {
            case SMALL -> s = 10;
            case MEDIUM -> s = 12;
            case LARGE -> s = 14;
        }
        return s + cheese * 2 + pepperoni * 2 + ham * 2;
    }
}
