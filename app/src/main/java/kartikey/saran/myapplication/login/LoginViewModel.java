package kartikey.saran.myapplication.login;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.rxjava2.RxDataStore;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import io.reactivex.Single;

public class LoginViewModel extends ViewModel {
    //
    private final String KEY = "loggedIn";
    private MutableLiveData<Boolean> isLoginSuccessful = new MutableLiveData<>();

    private void saveLoginState(boolean isLoggedIn, RxDataStore<Preferences> dataStoreRX) {
        Preferences.Key<Boolean> PREF_KEY = PreferencesKeys.booleanKey(KEY);
        Single<Preferences> updateResult =  dataStoreRX.updateDataAsync(prefsIn -> {
            MutablePreferences mutablePreferences = prefsIn.toMutablePreferences();
            mutablePreferences.set(PREF_KEY, isLoggedIn);
            return Single.just(mutablePreferences);
        });
    }

    public boolean getLoginState(RxDataStore<Preferences> dataStoreRX) {
        Preferences.Key<Boolean> PREF_KEY = PreferencesKeys.booleanKey(KEY);
        Single<Boolean> value = dataStoreRX.data().firstOrError().map(prefs -> prefs.get(PREF_KEY)).onErrorReturnItem(false);
        isLoginSuccessful.setValue(value.blockingGet());
        return value.blockingGet();
    }



    public LiveData<Boolean> getIsLoginSuccessful() {
        return isLoginSuccessful;
    }

    public boolean loginUser(String username, String password, RxDataStore<Preferences> dataStoreRX) {
        boolean isCorrect = username.equals("123") && password.equals("123");
        if (isCorrect) {
            saveLoginState(isCorrect, dataStoreRX);
            isLoginSuccessful.setValue(true);
            return true;
        } else {
            isLoginSuccessful.setValue(false);
            return false;
        }
    }
}

