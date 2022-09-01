package Java_lab3;

public enum Weekday {
    SUNDAY (true),
    MONDAY (false),
    TUESDAY (false),
    WEDNESDAY (false),
    THURSDAY (false),
    FRIDAY (false),
    SATURDAY (true);
    private final boolean weekend;
    Weekday(boolean d) { weekend = d; }
    public boolean isWeekEnd() { return weekend; }
    public boolean isWeekDay() { return !weekend; }
}
