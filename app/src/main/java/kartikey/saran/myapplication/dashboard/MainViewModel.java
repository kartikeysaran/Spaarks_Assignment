package kartikey.saran.myapplication.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import kartikey.saran.myapplication.model.User;
import kartikey.saran.myapplication.network.ApiClient;
import kartikey.saran.myapplication.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<User>> usersLiveData = new MutableLiveData<>();
    private ApiService apiService;

    public MainViewModel() {
        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        fetchUsers();
    }

    public LiveData<ArrayList<User>> getUsers() {
        return usersLiveData;
    }

    private void fetchUsers() {
        apiService.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {
                    usersLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                throw new RuntimeException(t.getMessage());
            }
        });
    }


}
