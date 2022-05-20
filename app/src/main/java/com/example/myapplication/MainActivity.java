package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.models.Game;
import com.example.myapplication.models.Player;
import com.example.myapplication.repositories.CardRepo;
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

    }


    public void obrir1rModo(View view){
        startActivity(new Intent(MainActivity.this, GameActivity.class));
    }

    public void obrir2nModo(View view){
        //startActivity(new Intent(MainActivity.this, GameActivity.class));
    }


}