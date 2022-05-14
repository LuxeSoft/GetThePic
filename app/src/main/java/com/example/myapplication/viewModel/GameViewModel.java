package com.example.myapplication.viewModel;

import android.app.AlertDialog;
import static java.util.concurrent.TimeUnit.SECONDS;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Game;
import com.example.myapplication.models.Level;
import com.example.myapplication.repositories.CardRepo;
import com.example.myapplication.repositories.LevelRepository;
import com.example.myapplication.repositories.MockLevelRepository;
import com.example.myapplication.utils.PreferencesProvider;
import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GameViewModel extends ViewModel {

    private static final String TAG = "GameViewModel";

    // @Jordi: Game hauria de tenir un attribut que representes el nivell.
    private Game game;

    public MutableLiveData<Level> levelMutableLiveData;

    // @Jordi: El ViewModel mai ha de tenir una dependència de la vista.
    // private FirstLevelView view;

    private CardRepo cardRepo;
    private LevelRepository levelRepository;
    //private GameRepo gameRepo;
    //private Nivell nivell;
    //public MutableLiveData<Nivell> nivell;


    // Control UX and UI
    //[levelImageMutable] -> urlImg
    //[lletra1]...[lletra8] -> cardEnums
    public MutableLiveData<String> levelImageMutable;

    //@TODO: Refactor this to use a MutableLiveData<List<CardEnum>>>
    public MutableLiveData<CardEnum> lletra1;
    public MutableLiveData<CardEnum> lletra2;
    public MutableLiveData<CardEnum> lletra3;
    public MutableLiveData<CardEnum> lletra4;
    public MutableLiveData<CardEnum> lletra5;
    public MutableLiveData<CardEnum> lletra6;
    public MutableLiveData<CardEnum> lletra7;
    public MutableLiveData<CardEnum> lletra8;

    public MutableLiveData<String> currentWordMutableLiveData;
    public MutableLiveData<Boolean> isLevelSolved;

    public MutableLiveData<String> username;
    public MutableLiveData<String> xp;

    public MutableLiveData<String> contador;

    public MutableLiveData<Boolean> faceUpCard;



    // Constructor
    public GameViewModel() {
        // Init all mutable data
        this.levelImageMutable = new MutableLiveData<>();
        this.lletra1 = new MutableLiveData<>();
        this.lletra2 = new MutableLiveData<>();
        this.lletra3 = new MutableLiveData<>();
        this.lletra4 = new MutableLiveData<>();
        this.lletra5 = new MutableLiveData<>();
        this.lletra6 = new MutableLiveData<>();
        this.lletra7 = new MutableLiveData<>();
        this.lletra8 = new MutableLiveData<>();
        this.levelMutableLiveData = new MutableLiveData<>();
        this.currentWordMutableLiveData = new MutableLiveData<>();
        this.isLevelSolved = new MutableLiveData<>();
        this.contador = new MutableLiveData<>();

        this.contador.setValue("0");

        this.faceUpCard = new MutableLiveData<>();
        this.faceUpCard.setValue(true);

        this.username = new MutableLiveData<>();
        this.xp = new MutableLiveData<>();

        this.xp.setValue(String.valueOf(0));

        int xp = PreferencesProvider.providePreferences().getInt("xp", 0);


        if(xp!=0){
            this.xp.setValue(String.valueOf(xp));

            //TODO: ACTUALITZAR TEXTVIEW AMB VALOR DE L'USUARI ACTUAL, SEMBLANT A:

            //PreferencesProvider.providePreferences().edit().putString("username", posar get de usuari).commit();
            //String username = PreferencesProvider.providePreferences().getString("username", "-");
            //this.username.setValue(username.toUpperCase());
        }

        // Init repos
        cardRepo = new CardRepo();

        /*@Jordi: Noteu, com hem definit una interficie amb les operacions i levelRepository està
        associat a la interfície, quan creu una nova classe que implementi la interficie per fer
        servir la base de dades, únicament caldrà canviar aquesta línia i la resta continuarà
        funcionant tot.
         */
        this.levelRepository = new MockLevelRepository();
    }

    // Methods

    public void getLevel(){
        // Get the level from the repo
        Level level = this.levelRepository.getLevel(0);
        // Update the mutable to tell the view that the level is loaded.
        this.levelMutableLiveData.setValue(level);
    }

    public LiveData<Level> isLevelLoaded(){
        return this.levelMutableLiveData;
    }

    public void updateLevel(Level level){

        Log.d(TAG, "updatingLevel... setting values to mutables.");
        this.levelImageMutable.setValue(level.getImageUrl());
        this.lletra1.setValue(level.getLetters().get(0));
        this.lletra2.setValue(level.getLetters().get(1));
        this.lletra3.setValue(level.getLetters().get(2));
        this.lletra4.setValue(level.getLetters().get(3));
        this.lletra5.setValue(level.getLetters().get(4));
        this.lletra6.setValue(level.getLetters().get(5));
        this.lletra7.setValue(level.getLetters().get(6));
        this.lletra8.setValue(level.getLetters().get(7));

        String currentUser = this.username.getValue();

        Log.d("currentUser",currentUser);

        //consultar nom del player i posar a:
        //PreferencesProvider.providePreferences().edit().putString("username", currentUser).commit();



    }



    public void setGame(Game game){
        this.game = game;
    }

    //TODO: POSAR TEMPORITZADOR 3 SEGONS. QUAN ACABA = GIRAR LLETRES
    public void temporitzador(){

    }



    public void comprovarParaula(){

        Level level = this.levelMutableLiveData.getValue();
        String word = this.game.getParaulaUsuari();

        String expectedWord = level.getSolution();

        Log.d(TAG, "comprovarParaula -> userWord:" + word);
        Log.d(TAG, "comprovarParaula -> expectedSolution:" + expectedWord);

        boolean solved = word.equalsIgnoreCase(expectedWord);
        this.isLevelSolved.setValue(solved);

        if(solved){

            int currentxp = Integer.parseInt(this.xp.getValue())+100;

            Log.d("xp", String.valueOf(currentxp));

            PreferencesProvider.providePreferences().edit().putInt("xp", currentxp).commit();

            //TODO: QUAN COMPLETA NIVELL, REFRESCAR PANTALA AMB SEGUENT NIVELL:
            //Level level = this.levelRepository.getLevel(0);


        }
    }



    public void resetLevel(){
        this.currentWordMutableLiveData.setValue("");
        this.game.setParaulaUsuari("");
    }

    public void onClickedAt(CardEnum c){

        if(this.faceUpCard.getValue()) {

            Log.d(TAG, "onClickedAt ->" + CardEnum.getMessageResource(c));
            // @Jordi: Això hauria de ser un setter i obtenir word amb un getter a la classe
            String word = game.concatenarLletres(c.toString());
            // @Jordi: Actualitzem el mutable per actualitzar la vista
            this.currentWordMutableLiveData.setValue(word);
        }
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        // Picasso.with(view.getContext()).setLoggingEnabled(true);
        Picasso.with(view.getContext()).load(imageUrl).into(view);
    }

}