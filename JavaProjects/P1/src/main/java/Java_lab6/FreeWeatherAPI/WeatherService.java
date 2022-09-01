package Java_lab6.FreeWeatherAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService
{
    @GET("/v1/forecast")
    Call<Weather>getWeather(@Query("latitude") float latitude, @Query("longitude") float longitude);
    @GET("/v1/forecast")
    Call<Weather>getWeather(@Query("latitude") float latitude, @Query("longitude") float longitude,
                            @Query("current_weather") boolean cw);
    @GET("/v1/forecast")
    Call<Weather>getWeather(@Query("latitude") float latitude, @Query("longitude") float longitude,
                            @Query("hourly") String[] temp);

}
