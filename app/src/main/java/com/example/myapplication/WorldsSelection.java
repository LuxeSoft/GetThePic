package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorldsSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worlds_selection);

        final Button button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WorldsSelection.this,FirstLevel.class));
            }
        });
    }


    public void AbrirSegundoMundo(View e){
        setContentView(R.layout.activity_segundo_mundo);
    }

    public void AbrirTercerMundo(View e){
        setContentView(R.layout.activity_tercer_mundo);
    }
}