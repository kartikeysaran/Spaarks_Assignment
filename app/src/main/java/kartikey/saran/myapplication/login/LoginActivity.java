package kartikey.saran.myapplication.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava2.RxDataStore;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import kartikey.saran.myapplication.R;
import kartikey.saran.myapplication.dashboard.MainActivity;
import kartikey.saran.myapplication.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;
    private RxDataStore<Preferences> dataStoreRX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        dataStoreRX = new RxPreferenceDataStoreBuilder(this,"user_login").build();
        viewModel = new ViewModelProvider(LoginActivity.this).get(LoginViewModel.class);
        viewModel.getLoginState(dataStoreRX);
        viewModel.getIsLoginSuccessful().observe(this, isSuccessful -> {
            if (isSuccessful) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        binding.btnLogin.setOnClickListener(v->{
            String username = binding.eTUsername.getText().toString();
            String password = binding.eTPassword.getText().toString();
            if(!viewModel.loginUser(username, password, dataStoreRX)){
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}