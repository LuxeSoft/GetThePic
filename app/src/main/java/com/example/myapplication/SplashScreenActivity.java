package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.utils.PreferencesProvider;

public class SplashScreenActivity extends AppCompatActivity {

    private String TAG = "SplashScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setup();
                data();
            }
        }, 3000);
    }

    private void setup(){
        PreferencesProvider.init(this);
    }

    private void data(){
        String token = PreferencesProvider.providePreferences().getString("token", "");
        Log.d(TAG, "token: " + token);
        if (token.equals("")) {
            // If device has no token -> go to LoginActivity()
            //startActivity(new Intent(this, LoginActivity.class));
            showLogin();
        } else {
            // If a userToken is stored on sharedPreferences go to MainActivity().
            startActivity(new Intent(this, MainActivity.class));
        }
        // Close the activity, the user don't need to enter again with back functionality
        finish();
    }

    private void showLogin(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}