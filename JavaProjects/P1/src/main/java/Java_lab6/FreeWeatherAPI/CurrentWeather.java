package Java_lab6.FreeWeatherAPI;

public class CurrentWeather {
    private String time;
    private float temperature;
    private int weathercode;
    private float windspeed;
    private int winddirection;
    public CurrentWeather(String time, float temperature, int weathercode, float windspeed, int winddirection) {
        this.time = time;
        this.temperature = temperature;
        this.weathercode = weathercode;
        this.windspeed = windspeed;
        this.winddirection = winddirection;
    }
    public String getWeather()
    {
        return String.format("\tTime: %s\n\tTemperature: %f\n\tWeathercode: %d\n\tWindspeed: %f\n\tWinddirection: %d",
                time, temperature, weathercode, windspeed, winddirection);
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public int getWeathercode() {
        return weathercode;
    }
    public void setWeathercode(int weathercode) {
        this.weathercode = weathercode;
    }
    public float getWindspeed() {
        return windspeed;
    }
    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }
    public int getWinddirection() {
        return winddirection;
    }
    public void setWinddirection(int winddirection) {
        this.winddirection = winddirection;
    }
}
