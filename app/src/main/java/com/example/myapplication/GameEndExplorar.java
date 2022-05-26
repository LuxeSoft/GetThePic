package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.utils.PreferencesProvider;

public class GameEndExplorar extends AppCompatActivity {

    TextView tvxp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end_explorar);

        //TODO POSAR XP FINAL

    }


    public void obrirMenuPrincipal(View view){
        startActivity(new Intent(GameEndExplorar.this, MainActivity.class));
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}