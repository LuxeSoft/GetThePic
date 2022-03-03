package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityFirstLevelBinding;
import com.example.myapplication.models.Game;
import com.example.myapplication.viewModel.GameViewModel;

public class FirstLevel extends AppCompatActivity {
    private GameViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFirstLevelBinding firstLevelBinding = DataBindingUtil.setContentView(this, R.layout.activity_first_level);
        viewModel = new GameViewModel();
        viewModel.initPartida(); //inicialitzar lletres
        firstLevelBinding.setGameViewModel(viewModel);

        Game game = new Game();
        game.setParaulaModel("arbre");

        ImageView imageView = findViewById(R.id.a);
        TextView tv = findViewById(R.id.paraulaEscrita);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("A");
            }
        });
    }


}