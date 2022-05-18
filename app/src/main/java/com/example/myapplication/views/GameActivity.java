package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.ActivityLevelsBinding;
import com.example.myapplication.models.Game;
import com.example.myapplication.models.Level;
import com.example.myapplication.utils.PreferencesProvider;
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
        binding.setLifecycleOwner(this);
    }


    private void data(){

        Game game  = new Game();
        viewModel.setGame(game);

        viewModel.temporitzador();

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

    public void pause(View view){

        Log.d("test","TEST");


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Menú de pausa");

        builder.setMessage("Que vols fer? :)");

        builder.setPositiveButton("Menú principal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               goTo();
            }
        });

        builder.setNeutralButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Resart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reStart();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    public void goTo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void reStart(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }



}