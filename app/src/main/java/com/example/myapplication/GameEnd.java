package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.views.GameActivity;

public class GameEnd extends AppCompatActivity {

    TextView tvxp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        //TODO POSAR XP FINAL

        tvxp = (TextView) findViewById(R.id.tvXpfinal);

        tvxp.setText(String.valueOf(PreferencesProvider.providePreferences().getInt("xp",0)));
    }


    public void obrirMenuPrincipal(View view){
        startActivity(new Intent(GameEnd.this, MainActivity.class));
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}