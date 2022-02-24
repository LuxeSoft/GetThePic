package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class WorldsSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worlds_selection);
    }

    public void AbrirPrimerMundo(View e){
        setContentView(R.layout.activity_primer_mundo);
    }

    public void AbrirSegundoMundo(View e){
        setContentView(R.layout.activity_segundo_mundo);
    }

    public void AbrirTercerMundo(View e){
        setContentView(R.layout.activity_tercer_mundo);
    }
}