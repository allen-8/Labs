package Java_lab4.Java_lab5.GeoCode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GeoCoderService {
    @GET("/{ip}")
    Call<GeoCode> getGeoCode(@Path("ip") String ip); // GET https://.../9.9.9.9

    /*
    @GET("/{country}/{ip}")
    Call<GeoCode> getGeoCode(@Path("ip") String ip,  @Path("country") String c); // GET https://.../ip
    */

}
