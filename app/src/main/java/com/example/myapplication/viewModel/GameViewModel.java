package com.example.myapplication.viewModel;

import static com.example.myapplication.models.CardEnum.c;
import static com.example.myapplication.models.CardEnum.ct;
import static com.example.myapplication.models.CardEnum.d;
import static com.example.myapplication.models.CardEnum.g;
import static com.example.myapplication.models.CardEnum.i;
import static com.example.myapplication.models.CardEnum.l;
import static com.example.myapplication.models.CardEnum.m;
import static com.example.myapplication.models.CardEnum.n;
import static com.example.myapplication.models.CardEnum.p;
import static com.example.myapplication.models.CardEnum.r;
import static com.example.myapplication.models.CardEnum.a;
import static com.example.myapplication.models.CardEnum.b;
import static com.example.myapplication.models.CardEnum.e;
import static com.example.myapplication.models.CardEnum.t;
import static com.example.myapplication.models.CardEnum.u;
import static com.example.myapplication.models.CardEnum.x;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.FirstLevel;
import com.example.myapplication.R;
import com.example.myapplication.models.Card;
import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Game;
import com.example.myapplication.views.FirstLevelView;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.TestOnly;

public class GameViewModel {

    private Game game;
    private FirstLevelView view;

    public MutableLiveData<CardEnum> lletra1;
    public MutableLiveData<CardEnum> lletra2;
    public MutableLiveData<CardEnum> lletra3;
    public MutableLiveData<CardEnum> lletra4;
    public MutableLiveData<CardEnum> lletra5;
    public MutableLiveData<CardEnum> lletra6;
    public MutableLiveData<CardEnum> lletra7;
    public MutableLiveData<CardEnum> lletra8;

    //private ImageView l1;


    public GameViewModel() {
        lletra1 = new MutableLiveData<CardEnum>();
        lletra2 = new MutableLiveData<CardEnum>();
        lletra3 = new MutableLiveData<CardEnum>();
        lletra4 = new MutableLiveData<CardEnum>();
        lletra5 = new MutableLiveData<CardEnum>();
        lletra6 = new MutableLiveData<CardEnum>();
        lletra7 = new MutableLiveData<CardEnum>();
        lletra8 = new MutableLiveData<CardEnum>();
    }

    /** public void initPartida()
     * Aquest metode inicialitza una lletra a cadascuna de les 8 cartes posicionades al joc.
     * @param
     * @return
     * @see
     */
    public void initPartida(){
        if (FirstLevel.nivell == 1){
            lletra1.setValue(ct);
            lletra2.setValue(a);
            lletra3.setValue(x);
            lletra4.setValue(e);
            lletra5.setValue(b);
            lletra6.setValue(r);
            lletra7.setValue(m);
            lletra8.setValue(n);
        } else if (FirstLevel.nivell == 2){
            lletra1.setValue(l);
            FirstLevel.l1.setImageResource(R.drawable.l);
            lletra2.setValue(p);
            FirstLevel.l2.setImageResource(R.drawable.p);
            lletra3.setValue(a);
            FirstLevel.l3.setImageResource(R.drawable.a);
            lletra4.setValue(c);
            FirstLevel.l4.setImageResource(R.drawable.c);
            lletra5.setValue(t);
            FirstLevel.l5.setImageResource(R.drawable.t);
            lletra6.setValue(u);
            FirstLevel.l6.setImageResource(R.drawable.u);
            lletra7.setValue(d);
            FirstLevel.l7.setImageResource(R.drawable.d);
            lletra8.setValue(i);
            FirstLevel.l8.setImageResource(R.drawable.i);
        }

    }

    public void setGame(Game game){
        this.game = game;
    }

    public void bind(FirstLevelView view){
        this.view = view;
    }

    public void comprovarParaula(){

        //FER TESTING DE LES 2 PARAULES:

        Log.d("viewmodel", "comprovarparaula:");
        Log.d("viewmodel", this.game.getParaulaModel());

        boolean semafor = this.view.getParaula().equalsIgnoreCase(this.game.getParaulaModel());
        Log.d("viewmodel", this.view.getParaula());

        Log.d("semafor", String.valueOf(semafor));

        this.view.showMessage(semafor);
    }

    /** public void onClickedAt()
     * Aquest metode mostra la lletra polsada.
     * @param c, la carta seleccionada.
     * @return
     * @see
     */
    public void onClickedAt(CardEnum c){
        Log.d("onclickedat", CardEnum.getMessageResource(c));
        //FirstLevel fl = new FirstLevel();
        //fl.mostrarLletra(c);
        this.view.mostrarLletra(c);
    }


}
