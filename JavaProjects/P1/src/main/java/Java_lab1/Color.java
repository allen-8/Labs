package Java_lab1;

public class Color
{
    private int r, g, b;
    private double r1, g1, b1, cmax, cmin, delta;
    Color()
    {
        r = 0; g = 0; b = 0;
    }
    private int check(int v, char n)
    {
        if (v < 0 || v > 255)
        {
            System.out.println("Invalid " + n + " parameter, " + n + "  set as '0'");
            return 0;
        }
        else
            return v;
    }
    Color(int r, int g, int b)
    {
        this.r = check(r, 'r');
        this.g = check(g, 'g');
        this.b = check(b, 'b');
        r1 = (double)this.r/255; g1 = (double)this.g/255; b1 = (double)this.b/255;
        if (r1 > g1 && r1 > b1)
        {
            cmax = r1;
            cmin = Math.min(g1, b1);
        }
        else if (g1 > r1 && g1 > b1)
        {
            cmax = g1;
            cmin = Math.min(r1, b1);
        }
        else
        {
            cmax = b1;
            cmin = Math.min(g1, r1);
        }
        delta = cmax - cmin;
    }
    public int hue()
    {
        if (delta == 0)
            return 0;
        if (cmax == r1)
            return (int)Math.round(60 *(((g1 - b1)/delta) % 6));
        if (cmax == g1)
            return (int)Math.round(60 * ((b1 - r1)/delta + 2));
        return (int)Math.round(60 * ((r1 - g1)/delta + 4));
    }
    public int lightness() { return (int)Math.round(((cmax + cmin) / 2) * 100); }
    public int saturation()
    {
        return (delta == 0) ? 0 : (int)Math.round((delta / (1 - Math.abs(2 * ((cmax + cmin)/2) - 1))) * 100);
    }
}
