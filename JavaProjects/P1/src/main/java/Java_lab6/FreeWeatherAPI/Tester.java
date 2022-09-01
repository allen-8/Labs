package Java_lab6.FreeWeatherAPI;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
public class Tester
{
    public static void main(String[] args) throws IOException
    {
        WeatherService ws = new Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherService.class);
        String[] str = {"1", "3", "4"};
        Response<Weather> r1 = ws.getWeather((float)52.52, (float)13.41, str).execute();
        if (r1.errorBody() == null)
            System.out.println(r1.body().getWeather());
        else
            System.out.println(r1.errorBody().string());
    }
}
