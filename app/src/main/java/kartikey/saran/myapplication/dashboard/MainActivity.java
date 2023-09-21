package kartikey.saran.myapplication.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import kartikey.saran.myapplication.R;
import kartikey.saran.myapplication.adapter.UserAdapter;
import kartikey.saran.myapplication.databinding.ActivityMainBinding;
import kartikey.saran.myapplication.layout_manager.CustomLayoutManager;
import kartikey.saran.myapplication.model.User;
import kartikey.saran.myapplication.network.ApiClient;
import kartikey.saran.myapplication.network.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ActivityMainBinding binding;
    private GoogleMap mMap;
    private MapView mMapView;
    private UserAdapter userAdapter;
    private MainViewModel viewModel;
    private ArrayList<User> userList;
    private static final int REQUEST_LOCATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        } else {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
            viewModel = new ViewModelProvider(this).get(MainViewModel.class);
            mMapView = binding.mapView;
            mMapView.onCreate(savedInstanceState);
            mMapView.getMapAsync(this);
            RecyclerView recyclerView = binding.recyclerview;
            recyclerView.setLayoutManager(new CustomLayoutManager(this));
            recyclerView.setNestedScrollingEnabled(false);
            userAdapter = new UserAdapter(new ArrayList<>());
            recyclerView.setAdapter(userAdapter);
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
            itemTouchHelper.attachToRecyclerView(recyclerView);
            viewModel.getUsers().observe(this, users -> {
                userList = users;
                userAdapter.setUsers(userList);
                setLatLon();
            });
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    private void setLatLon() {
        if(mMap != null) {
            double latitude = Double.parseDouble(userList.get(0).getAddress().getGeo().getLat());
            double longitude = Double.parseDouble(userList.get(0).getAddress().getGeo().getLng());
            LatLng location = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(location).title(userList.get(0).getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
        }
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            int position = viewHolder.getAdapterPosition();
            userList.remove(position);
            userAdapter.notifyItemRemoved(position);
            setLatLon();
        }
    };
}