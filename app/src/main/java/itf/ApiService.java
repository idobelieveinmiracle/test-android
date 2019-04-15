package itf;

import models.Item;
import models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("items/{id}")
    Call<Item> getItem(@Path("id") String id);

    @POST("users/login")
    Call<User> login(@Body User user);
}
