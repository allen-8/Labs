package Java_lab6.FreeWeatherAPI;
public class Weather
{
    private float latitude, longitude, elevation, generationtime_ms;
    private int utc_offset_seconds;
    private String timezone, timezone_abbreviation;
    private Hourly hourly = null;
    private HourlyUnits hourly_units;
    private CurrentWeather current_weather = null;
    public Weather(float latitude, float longitude, float elevation, float generationtime_ms, int utc_offset_seconds,
                   String timezone, String timezone_abbreviation, Hourly hourly, HourlyUnits hourly_units,
                   CurrentWeather current_weather) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.generationtime_ms = generationtime_ms;
        this.utc_offset_seconds = utc_offset_seconds;
        this.timezone = timezone;
        this.timezone_abbreviation = timezone_abbreviation;
        this.hourly = hourly;
        this.hourly_units = hourly_units;
        this.current_weather = current_weather;
    }
    public String getWeather()
    {
        String str= String.format("Latitude: %f\nLongitude: %f\nElevation: %f\nGeneration Time (ms): %f\n" +
                "Utc Offset (seconds): %d\nTimezone: %s\nTimezone Abbreviation: %s\n",
                latitude, longitude, elevation, generationtime_ms, utc_offset_seconds, timezone,
                timezone_abbreviation);
        if (hourly != null)
            str = str + "Hourly:\n" + hourly.getHourly();
        if (current_weather != null)
            str = str + "Current Weather:\n" + current_weather.getWeather();
        return str;
    }

    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public float getElevation() {
        return elevation;
    }
    public void setElevation(float elevation) {
        this.elevation = elevation;
    }
    public float getGenerationtime_ms() {
        return generationtime_ms;
    }
    public void setGenerationtime_ms(float generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }
    public int getUtc_offset_seconds() {
        return utc_offset_seconds;
    }
    public void setUtc_offset_seconds(int utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }
    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }
    public Hourly getHourly() {
        return hourly;
    }
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }
    public HourlyUnits getHourly_units() {
        return hourly_units;
    }
    public void setHourly_units(HourlyUnits hourly_units) {
        this.hourly_units = hourly_units;
    }
    public CurrentWeather getCurrent_weather() {
        return current_weather;
    }
    public void setCurrent_weather(CurrentWeather current_weather) {
        this.current_weather = current_weather;
    }
}
