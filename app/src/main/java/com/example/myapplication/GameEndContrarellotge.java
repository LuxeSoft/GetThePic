package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.utils.PreferencesProvider;

public class GameEndContrarellotge extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_contrarellotge);

        TextView tvContadorFinal;

        tvContadorFinal = (TextView) findViewById(R.id.tvContadorFinal);

        tvContadorFinal.setText(String.valueOf(PreferencesProvider.providePreferences().getInt("resoltesContra",0)));
    }

    public void obrirMenuPrincipal(View view){
        startActivity(new Intent(GameEndContrarellotge.this, MainActivity.class));
    }

}