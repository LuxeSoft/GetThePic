package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.viewModel.GameViewModel;

public class GameEndContrarellotge extends AppCompatActivity {

    TextView tvContadorFinal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_contrarellotge);


        tvContadorFinal2 = (TextView) findViewById(R.id.tvContadorFinal);

        tvContadorFinal2.setText(String.valueOf(PreferencesProvider.providePreferences().getInt("resoltes",0)));

    }

    public void obrirMenuPrincipal(View view){
        startActivity(new Intent(GameEndContrarellotge.this, MainActivity.class));
    }

}