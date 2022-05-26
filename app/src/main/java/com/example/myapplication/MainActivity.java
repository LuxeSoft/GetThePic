package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ShareActionProvider;

import com.example.myapplication.models.Game;
import com.example.myapplication.models.Player;
import com.example.myapplication.repositories.CardRepo;
import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.views.GameActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AboutPage.class));
            }
        });


        PreferencesProvider.providePreferences().edit().putInt("resoltes", 0).commit();
    }


    public void obrir1rModo(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        PreferencesProvider.providePreferences().edit().putString("mode", "explorar").commit();
        PreferencesProvider.providePreferences().edit().putString("temporitzadorContrarrelotge", "30").commit();

        startActivity(intent);
    }

    public void obrir2nModo(View view){
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        PreferencesProvider.providePreferences().edit().putString("mode", "contrarellotge").commit();
        PreferencesProvider.providePreferences().edit().putString("temporitzadorContrarrelotge", "30").commit();

        startActivity(intent);

    }


}