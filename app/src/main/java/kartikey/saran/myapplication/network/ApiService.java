package kartikey.saran.myapplication.network;

import java.util.ArrayList;

import kartikey.saran.myapplication.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/users")
    Call<ArrayList<User>> getUsers();
}
