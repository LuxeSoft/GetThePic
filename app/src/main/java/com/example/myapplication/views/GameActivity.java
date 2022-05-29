package com.example.myapplication.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.GameEndExplorar;
import com.example.myapplication.GameEndContrarellotge;
import com.example.myapplication.MainActivity;
import com.example.myapplication.databinding.ActivityLevelsBinding;
import com.example.myapplication.models.Game;
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

    // Private methods------------------------------------------------------------------------------

    private void setup(){
        binding.setGameViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }


    private void data(){

        Log.d("init data", "init data");

        Game game  = new Game();
        viewModel.setGame(game);

        Log.d("mode",PreferencesProvider.providePreferences().getString("mode", ""));

        viewModel.setMode(PreferencesProvider.providePreferences().getString("mode",""));

        viewModel.temporitzador();

        // @Jordi: Iniciem l'operació per obtenir el nivell
        Log.d(TAG, "data() -> loading the level...");
        int levelShared = PreferencesProvider.providePreferences().getInt("nivell",0);
        viewModel.getLevel(levelShared);


        //Fem un observer per quan acabi el mode contrarellotge
        //si acaba el temps del contrarellotge salta al metode clockEnd
        viewModel.isEndCr.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if(viewModel.isEndCr.getValue()){
                    Log.d("valor", String.valueOf(viewModel.isEndCr));
                    clockEnd();
                }
            }
        });

        // @Jordi: Observem quan el nivell ha estat carregat
        viewModel.isLevelLoaded().observe(this, level -> {

            //si el mode es explorar
            if (viewModel.getMode() == 1) {

                Log.d(TAG, "data() -> level is loaded -> " + level.toString());

                //si hi han més nivells salta al seguent nivell
                if (viewModel.hiHaMesNivells()) {
                    viewModel.updateLevel(level);
                //si no hi han més nivells mostra la pantalla final
                } else {
                    showEndPage();
                }
            //si el mode es contrarellotge canvia de nivell
            } else {
                viewModel.updateLevel(level);
            }
        });


        //@Didac: Aqui tens un mutable que s'observa quan comproves la paraula. Per tant, aqui pots activar la funció de mostrar TOAST.
        viewModel.isLevelSolved.observe(this, solved -> {

        //si el mode es explorar
        if(viewModel.getMode() == 1) {
            Log.d(TAG, "data() -> is level solved? -> " + solved.toString());
            //si ha encertat la paraula
            if (solved) {
                // Mostrareu el dialog i carregarem un nou nivell
                Log.d(TAG, "Encertat");
                missatgeResposta("Resposta correcta! :)");

                //si hi han més nivells refresca l'activitat, refresca la pantalla per a que surti una altra paraula
                if (viewModel.hiHaMesNivells()) {

                    Log.d("hihames nivells", "hi ha mes nivells");

                    startActivity(new Intent(GameActivity.this, GameActivity.class));

                    finish();
                //si no hi ha més nivells salta a la pantalla final
                } else {
                    showEndPage();
                }
            //si no ha encertat la paraula
            } else {
                // Mostrareu el dialog i si l'usuari vol continuar jugant reset el nivell
                Log.d(TAG, "No encertat");
                missatgeResposta("No has encertat :(");
                viewModel.resetLevel();
            }
        //si el mode es contrarellotge
        } else {
            //si ha encertat la paraula refresca l'activitat, refresca la pantalla per a que surti una altra paraula
            if(solved){
                Log.d(TAG, "Encertat");
                missatgeResposta("Resposta correcta! :)");

                startActivity(new Intent(GameActivity.this, GameActivity.class));
                finish();
            //si no ha encertat la paraula si el usuari vol continuar jugant reset el nivell
            } else {
                Log.d(TAG, "No encertat");
                missatgeResposta("No has encertat :(");

                viewModel.resetLevel();
            }
        }
        });

    }

    //si clica al boto de pausar mostra diferents opcions
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

    // Public methods-------------------------------------------------------------------------------

    public void missatgeResposta(String msj){

        Context context = getApplicationContext();

        Toast toast = Toast.makeText(context, msj, Toast.LENGTH_SHORT);
        toast.show();

    }

    public void goTo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void reStart(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void showEndPage(){
        Intent intent = new Intent(this, GameEndExplorar.class);
        startActivity(intent);
    }

    public void clockEnd(){
        Intent intent = new Intent(this, GameEndContrarellotge.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
     goTo();
     finish();
    }

}