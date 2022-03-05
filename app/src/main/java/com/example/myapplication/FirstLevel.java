package com.example.myapplication;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.DialogInterface;
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
import com.example.myapplication.models.Player;
import com.example.myapplication.viewModel.GameViewModel;
import com.example.myapplication.views.FirstLevelView;
import com.google.android.material.snackbar.Snackbar;

public class FirstLevel extends AppCompatActivity implements FirstLevelView {

    private TextView tv; //textview on posem la paraula q va escrivint l'usuari
    private TextView user_tv; //textview on posem nomusuari
    private TextView xp_tv; //textview on posem xp usuari

    private GameViewModel viewModel;
    Game game;
    Player p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFirstLevelBinding firstLevelBinding = DataBindingUtil.setContentView(this, R.layout.activity_first_level);

        viewModel = new GameViewModel();
        game = new Game();
        tv = (TextView) findViewById(R.id.paraulaEscrita);
        user_tv = (TextView)findViewById(R.id.user_tv);
        xp_tv = (TextView) findViewById(R.id.xp_tv);
        p1 = new Player("user", 0, 0);

        viewModel.bind(this);
        viewModel.initPartida(); //inicialitzar lletres
        game.setParaulaModel("arbre");
        tv.setText("");
        user_tv.setText(p1.getName());
        xp_tv.setText(String.valueOf(p1.getXp()));

        firstLevelBinding.setGameViewModel(viewModel);

        viewModel.setGame(game);

    }

    /**
     * mostrarLLetra ens defineix, al textview, la paraula q va introduint l'usuari. la
     * paraula es va concatenant lletra x lletra
     * @param  CardEnum c  la carta q apreta el usuari
     * @return  void
     */

    @Override
    public void mostrarLletra(CardEnum c) {

        Log.d("onclick",c.toString());

        String paraula = game.concatenarLletres(c.toString());

        Log.d("onclick",paraula);

        tv.setText(paraula);


    }

    /**
     * getter per obtenir paraula q ha introduit l'usuari
     * @return  valor del textview q s'ha ant escrivint
     */

    @Override
    public String getParaula(){
        return tv.getText().toString();
    }

    /**
     * showMessage ens mostrara si l'usuari ha encertat o no la paraula q ha escrit
     * @param  semafor  la paraula introduida x lusuari coincideix amb la paraula model? true/false
     * @param  name the location of the image, relative to the url argument
     * @return      void
     */

    @Override
    public void showMessage(boolean semafor){

        /*Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

        int duration = Toast.LENGTH_SHORT; // toast
        Context context = getApplicationContext();// toast
        AlertDialog.Builder builder = new AlertDialog.Builder(this); //alerta de quan guanya o perd

        if (semafor == true){
            Toast toast = Toast.makeText(context, "ENHORABONA! :)", duration);
            toast.show();

            builder.setTitle("Paraules iguals!");
            builder.setMessage("Has obtingut +100 punts de xp");
            p1.sumarXP();
            xp_tv.setText(String.valueOf(p1.getXp()));

            builder.setPositiveButton("continuar jugant", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   //començar nova activitat amb següent nivell
                }
            });

            builder.setNegativeButton("tornar al menú principal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(FirstLevel.this,MainActivity.class));
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        } else {
            Toast toast = Toast.makeText(context, "LLASTIMA! :(", duration);
            toast.show();
            builder.setTitle("No has endevinat la foto :(");
            builder.setMessage("Que vols fer?");

            builder.setPositiveButton("tornar a intentar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    tv.setText("");
                    game.borrarParaulaUsuari();
                }
            });

            builder.setNegativeButton("tornar al menú principal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(FirstLevel.this,MainActivity.class));
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }

    }

}