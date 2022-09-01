package Java_lab6.FreeWeatherAPI;

public class HourlyUnits
{
    private String temperature_2m;
    public HourlyUnits(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
    public String getTemperature_2m() {
        return temperature_2m;
    }
    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
}
