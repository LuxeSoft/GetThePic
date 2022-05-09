package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.example.myapplication.databinding.ActivityRegistreBinding;
import com.example.myapplication.models.Result;
import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.utils.UIUtils;
import com.example.myapplication.viewModel.SingInViewModel;

public class SingInActivity extends AppCompatActivity {

    private final String TAG = "SingInActivity";
    private SingInViewModel singInViewModel;
    private ActivityRegistreBinding activitySinginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        singInViewModel = new SingInViewModel();
        initDataBinding();

        singInViewModel.isUserLogged().observe(this, new Observer<Result<String>>() {
            @Override
            public void onChanged(Result<String> tokenResult) {
                singInViewModel.isLogged.postValue(false);
                if (tokenResult.getResult() != null){
                    Log.d(TAG,"Login successful, token obtained.");
                    PreferencesProvider.providePreferences().edit().putString("token",
                            tokenResult.getResult()).commit();
                    Log.d(TAG,"Login successful, add token to SharedPreferences.");
                    goTo();
                }
                else{
                    //Display Error
                    Log.d(TAG,"User not logged, token not obtained.");
                    showSingInError(tokenResult.getError().getMessage());
                }
            }
        });

    }

    public void initDataBinding() {
        activitySinginBinding =  DataBindingUtil.setContentView(this,R.layout.activity_registre);

        activitySinginBinding.setSingInViewModel(singInViewModel);
        activitySinginBinding.setLifecycleOwner(this);
    }

    public void goTo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showSingInError(String errorMessage){
        DialogInterface.OnClickListener positiveAction = (dialogInterface, i) -> dialogInterface.cancel();
        UIUtils.showAlert(this,"Error", errorMessage, "Ok",positiveAction ,null,null, false);
    }


}
