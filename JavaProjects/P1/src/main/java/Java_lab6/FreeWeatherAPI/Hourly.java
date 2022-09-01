package Java_lab6.FreeWeatherAPI;

public class Hourly
{
    private String[] time;
    private float[] temperature_2m;
    public Hourly(String[] time, float[] temperature_2m) {
        this.time = time;
        this.temperature_2m = temperature_2m;
    }
    public String getHourly()
    {
        String str = "";
        for (int i = 0; i < time.length; ++i)
            str = str + time[i] + " - " +  temperature_2m[i] + "\n";
        return str;
    }
    public String[] getTime() {
        return time;
    }
    public void setTime(String[] time) {
        this.time = time;
    }
    public float[] getTemperature_2m() {
        return temperature_2m;
    }
    public void setTemperature_2m(float[] temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
}
