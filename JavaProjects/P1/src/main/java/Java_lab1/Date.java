package Java_lab1;

public class Date
{
    private int day, month, year;
    Date()
    {
        year = 1970; month = 1; day = 1;
    }
    Date(int d, int m, int y)
    {
        year = y;
        if (m > 0 && m < 13)
            month = m;
        else
        {
            month = 1;
            System.out.println("Invalid month value, month set as '1'");
        }
        if (d < 1 || d > 31 || (month == 2 && d > 29) ||
                ((month == 4 || month == 6 || month == 9 || month == 11) && d > 30))
        {
            day = 1;
            System.out.println("Invalid day value, day set as '1'");
        }
        else
            day = d;
    }
    int getYear() { return year; }
    int getMonth() { return month; }
    int getDay() { return day; }
    void setYear(int y) { year = y; }
    void setMonth(int m)
    {
        if ((m == 2 && day > 29) || ((m == 4 || m == 6 || m == 9 || m == 11) && day == 31)
        || m < 1 || m > 31)
            System.out.println("Invalid month value!");
        else
            month = m;
    }
    void setDay(int d)
    {
        if (d < 1 || d > 31 || (month == 2 && d > 29) ||
                ((month == 4 || month == 6 || month == 9 || month == 11) && d > 30))
            System.out.println("Invalid day value!");
        else
            day = d;
    }
    @Override
    public String toString() { return String.format("%d-%02d-%02d", year, month, day); }
    public void addDay()
    {
        ++day;
        if ((month == 2 && day > 29) || ((month == 4 || month == 6 || month == 9 || month == 11)
        && day > 30) || day > 31)
        {
            day = 1;
            ++month;
        }
        if (month > 12)
        {
            month = 1;
            ++year;
        }
    }
}
