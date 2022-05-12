package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.ActivityLevelsBinding;
import com.example.myapplication.models.Game;
import com.example.myapplication.models.Level;
import com.example.myapplication.viewModel.GameViewModel;

public class GameActivity extends AppCompatActivity {

    private static final String TAG = "GameActivity";

    private GameViewModel viewModel;
    private ActivityLevelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // @Jordi: Bind the xml with the activity (ActivityLevelsBinding is auto generated).
        binding = ActivityLevelsBinding.inflate(getLayoutInflater());

        // Set the Content of the xml to the view
        setContentView(binding.getRoot());

        // Set the viewModel
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);


        setup();
        data();

    }


    // Private methods

    private void setup(){
        binding.setGameViewModel(viewModel);
    }


    private void data(){

        Game game  = new Game();
        viewModel.setGame(game);

        // @Jordi: Iniciem l'operació per obtenir el nivell
        Log.d(TAG, "data() -> loading the level...");
        viewModel.getLevel();

        // @Jordi: Observem quan el nivell ha estat carregat
        viewModel.isLevelLoaded().observe(this, level -> {
            Log.d(TAG, "data() -> level is loaded -> " + level.toString());
            viewModel.updateLevel(level);
        });

        viewModel.isLevelSolved.observe(this, solved -> {
            Log.d(TAG, "data() -> is level solved? -> " + solved.toString());
            if (solved){
                // Mostrareu el dialog i carregarem un nou nivell
                startActivity(new Intent(GameActivity.this, GameActivity.class));
                finish();
            } else {
                // Mostrareu el dialog i si l'usuari vol continuar jugant reset el nivell
                viewModel.resetLevel();
            }
        });

    }

}