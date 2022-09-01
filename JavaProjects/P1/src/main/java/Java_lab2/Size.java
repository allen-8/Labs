package Java_lab2;

public enum Size
{
    SMALL ("Small"),
    MEDIUM ("Medium"),
    LARGE ("Large");
    private final String name;
    Size(String n) { name = n; }
    String getName() { return name; }
}
