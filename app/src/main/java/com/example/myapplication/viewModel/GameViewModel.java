package com.example.myapplication.viewModel;

import static com.example.myapplication.models.CardEnum.r;
import static com.example.myapplication.models.CardEnum.a;
import static com.example.myapplication.models.CardEnum.b;
import static com.example.myapplication.models.CardEnum.e;


import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.R;
import com.example.myapplication.models.Card;
import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Game;

public class GameViewModel {

    private Game game;
    private View view;


    public MutableLiveData<CardEnum> lletra1;
    public MutableLiveData<CardEnum> lletra2;
    public MutableLiveData<CardEnum> lletra3;
    public MutableLiveData<CardEnum> lletra4;
    public MutableLiveData<CardEnum> lletra5;
    public MutableLiveData<CardEnum> lletra6;
    public MutableLiveData<CardEnum> lletra7;
    public MutableLiveData<CardEnum> lletra8;

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

    public void initPartida(){
        lletra1.setValue(a);
        lletra2.setValue(r);
        lletra3.setValue(b);
        lletra4.setValue(e);
        lletra5.setValue(a);
        lletra6.setValue(CardEnum.getRandomCard());
        lletra7.setValue(b);
        lletra8.setValue(r);
    }

    public void onClickedAt(CardEnum c){
        Log.d("onclickedat", CardEnum.getMessageResource(c));
    }

    public GameViewModel(View view){
        game = new Game();
        this.view = view;
    }

    public void completarParaula(String letter){
       String paraula = game.concatenarLletres(letter);

    }
}
