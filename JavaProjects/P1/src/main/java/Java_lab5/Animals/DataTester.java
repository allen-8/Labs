package Java_lab4.Java_lab5.Animals;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;

public class DataTester
{
    public static void main(String[] args) throws IOException
    {
        DataService ds = new Retrofit.Builder()
                .baseUrl("https://zoo-animal-api.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DataService.class);
        Response<Animal>r1 = ds.getAnimal().execute();
        if (r1.isSuccessful())
            System.out.println(r1.body().getData());
        Response<List<Animal>>r2 = ds.getAnimals(4).execute();
        if (r2.isSuccessful())
        {
            for (Animal a : r2.body())
                System.out.println(a.getData());
        }
    }
}
