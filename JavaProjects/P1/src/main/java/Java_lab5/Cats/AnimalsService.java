package Java_lab4.Java_lab5.Cats;
/*
https://cat-fact.herokuapp.com
    /facts/random
            ?animal_type=dog&amount=2

 */

// https://square.github.io/retrofit/
//  facts/random/dog/4
//  facts/random/{animal}/{number} // @Path

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AnimalsService {
    // https://cat-fact.herokuapp.com/facts/random?animal_type=dog&amount=2

    // facts/random?animal_type=dog&amount=2 // @Query ? и & добавляются автоматически
    @GET("facts/random")
    Call<List<Fact>> getFacts(
            @Query("animal_type") String animal, // dog
            @Query("amount") int number
    );

    @GET("facts/random")
    Call<Fact> getFact();
}
