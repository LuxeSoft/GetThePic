package com.example.myapplication;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityFirstLevelBinding;
import com.example.myapplication.models.Card;
import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Game;
import com.example.myapplication.viewModel.GameViewModel;
import com.example.myapplication.views.FirstLevelView;
import com.google.android.material.snackbar.Snackbar;

public class FirstLevel extends AppCompatActivity implements FirstLevelView {

    private GameViewModel viewModel;
    private String paraula = "";
    Game game;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFirstLevelBinding firstLevelBinding = DataBindingUtil.setContentView(this, R.layout.activity_first_level);
        viewModel = new GameViewModel();
        viewModel.bind(this);
        viewModel.initPartida(); //inicialitzar lletres
        firstLevelBinding.setGameViewModel(viewModel);


        tv = (TextView) findViewById(R.id.paraulaEscrita);
        tv.setText("");

        game = new Game();
        game.setParaulaModel("arbre");
        viewModel.setGame(game);
        //ImageView imageView = findViewById(R.id.a);

        /*imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tv.setText("A");
            }
        });*/

        /*/*Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
    }


    private void setUpOnGameEndListener() {
      //viewModel.getWinner().observe(this, this::onGameWinnerChanged);
    }

    @Override
    public void mostrarLletra(CardEnum c) {

        Log.d("onclick",c.toString());

        String paraula = game.concatenarLletres(c.toString());

        Log.d("onclick",paraula);

        tv.setText(paraula);


    }

    @Override
    public String getParaula(){
        return tv.getText().toString();
    }

    @Override
    public void showMessage(boolean semafor){

        if (semafor == true){
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "ok", duration);
            toast.show();
        } else {
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, "no igual", duration);
            toast.show();
        }

    }

}