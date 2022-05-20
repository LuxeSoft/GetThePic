package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.ActivityAccedirBinding;
import com.example.myapplication.models.Result;
import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.utils.UIUtils;
import com.example.myapplication.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "LoginActivity";
    private LoginViewModel loginViewModel;
    private ActivityAccedirBinding activityLoginBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accedir);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        initDataBinding();
        //loginViewModel = new LoginViewModel();

        //COMENTAR =  SI LOGIN
        //NO COMENTAR =  NO LOGIN
        goTo();

        loginViewModel.isUserLogged().observe(this, new Observer<Result<String>>() {
            @Override
            public void onChanged(Result<String> tokenResult) {
                loginViewModel.isLogged.postValue(false);
                if (tokenResult.getResult() != null){
                    Log.d(TAG,"Login successful, token obtained.");
                    PreferencesProvider.providePreferences().edit().putString("token",
                            tokenResult.getResult()).commit();
                    PreferencesProvider.providePreferences().edit().putString("username",
                            loginViewModel.getEmailLiveData().getValue()).commit();
                    Log.d(TAG,"Login successful, add token to SharedPreferences.");

                    goTo();
                }
                else{
                    //Display Error
                    Log.d(TAG,"User not logged, token not obtained.");
                    showLoginError(tokenResult.getError().getMessage());
                }
            }
        });


        final Button button = (Button) findViewById(R.id.bototmp);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SingInActivity.class));
            }
        });

    }

    public void initDataBinding() {
        activityLoginBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_accedir);
        activityLoginBinding.setLoginViewModel(loginViewModel);
        activityLoginBinding.setLifecycleOwner(this);
    }

    public void goTo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToCreateUser(){
        Log.d("test", "createuser");
        Intent intent = new Intent(this, SingInActivity.class);
        startActivity(intent);
    }

    private void showLoginError(String errorMessage){
        DialogInterface.OnClickListener positiveAction = (dialogInterface, i) -> dialogInterface.cancel();
        UIUtils.showAlert(this,"Error", errorMessage, "Ok",positiveAction ,null,null, false);
    }


}
