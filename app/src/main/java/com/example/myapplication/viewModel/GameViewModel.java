package com.example.myapplication.viewModel;

import android.app.AlertDialog;
import static java.util.concurrent.TimeUnit.SECONDS;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.views.GameActivity;
import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Game;
import com.example.myapplication.models.Level;
import com.example.myapplication.repositories.CardRepo;
import com.example.myapplication.repositories.LevelRepository;
import com.example.myapplication.repositories.MockLevelRepository;
import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.views.GameActivity;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GameViewModel extends ViewModel {

    private static final String TAG = "GameViewModel";

    // @Jordi: Game hauria de tenir un attribut que representes el nivell.
    private Game game;
    private GameActivity gameActivity;


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
    public MutableLiveData<Boolean> faceUpCardLletra1;
    public MutableLiveData<Boolean> faceUpCardLletra2;
    public MutableLiveData<Boolean> faceUpCardLletra3;
    public MutableLiveData<Boolean> faceUpCardLletra4;
    public MutableLiveData<Boolean> faceUpCardLletra5;
    public MutableLiveData<Boolean> faceUpCardLletra6;
    public MutableLiveData<Boolean> faceUpCardLletra7;
    public MutableLiveData<Boolean> faceUpCardLletra8;




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

        gameActivity = new GameActivity();

        this.contador.setValue("0");

        this.faceUpCard = new MutableLiveData<>(); //TODO: @Didac Tal com teniu ara, aquest Mutable us els controla tots, per tal de que nomes es giri la carta que apreteu, en necessiteu un per cada carta.
        this.faceUpCard.setValue(true);

        //TODO: Testing @Didac Comentem la proposta dijous
        this.faceUpCardLletra1 = new MutableLiveData<>();
        this.faceUpCardLletra1.setValue(true);

        //TODO: Testing @Didac Comentem la proposta dijous. En el XML també us he afegit canvis en la carta 1 i 2 per a que es mostrin quan es cliqui.
        this.faceUpCardLletra2 = new MutableLiveData<>();
        this.faceUpCardLletra2.setValue(true);

        this.faceUpCardLletra3 = new MutableLiveData<>();
        this.faceUpCardLletra3.setValue(true);

        this.faceUpCardLletra4 = new MutableLiveData<>();
        this.faceUpCardLletra4.setValue(true);

        this.faceUpCardLletra5 = new MutableLiveData<>();
        this.faceUpCardLletra5.setValue(true);

        this.faceUpCardLletra6 = new MutableLiveData<>();
        this.faceUpCardLletra6.setValue(true);


        this.faceUpCardLletra7 = new MutableLiveData<>();
        this.faceUpCardLletra7.setValue(true);

        this.faceUpCardLletra8 = new MutableLiveData<>();
        this.faceUpCardLletra8.setValue(true);

        //TODO: Fins aqui @Didac

        this.username = new MutableLiveData<>();
        this.xp = new MutableLiveData<>();

        this.xp.setValue(String.valueOf(0));

        int xp = PreferencesProvider.providePreferences().getInt("xp", 0);

        //TODO: @Didac en la part de login he guardat el nom que l'usuari entra per fer el login en el sharedpreferences. Aqui puc recuperar aquest nom.
        //TODO: @Didac amb la següent linia podreu obtenir aquest nom des d'on vulgueu.
        String currentUsername = PreferencesProvider.providePreferences().getString("username", "");
        username.setValue(currentUsername.toUpperCase(Locale.ROOT));

        if(xp!=0){
            this.xp.setValue(String.valueOf(xp));
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
    //TODO: @Didac, podeu aprofitar el pause que teniu en el splashScreen
    public void temporitzador(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                faceUpCard.setValue(false);
                faceUpCardLletra1.setValue(false);
                faceUpCardLletra2.setValue(false);
                faceUpCardLletra3.setValue(false);
                faceUpCardLletra4.setValue(false);
                faceUpCardLletra5.setValue(false);
                faceUpCardLletra6.setValue(false);
                faceUpCardLletra7.setValue(false);
                faceUpCardLletra8.setValue(false);
            }
        }, 4000);

    }


    public void temporitzadorObrir(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                faceUpCard.setValue(true);
                faceUpCardLletra1.setValue(true);
                faceUpCardLletra2.setValue(true);
                faceUpCardLletra3.setValue(true);
                faceUpCardLletra4.setValue(true);
                faceUpCardLletra5.setValue(true);
                faceUpCardLletra6.setValue(true);
                faceUpCardLletra7.setValue(true);
                faceUpCardLletra8.setValue(true);

                temporitzador();

            }
        }, 1000);

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
        Log.d(TAG, c.name());
        Log.d(TAG, "onClickedAt ->" + CardEnum.getMessageResource(c));
        // @Jordi: Això hauria de ser un setter i obtenir word amb un getter a la classe
        String word = game.concatenarLletres(c.toString());
        // @Jordi: Actualitzem el mutable per actualitzar la vista
        this.currentWordMutableLiveData.setValue(word);

        /*if(this.faceUpCard.getValue()) {

            Log.d(TAG, "onClickedAt ->" + CardEnum.getMessageResource(c));
            // @Jordi: Això hauria de ser un setter i obtenir word amb un getter a la classe
            String word = game.concatenarLletres(c.toString());
            // @Jordi: Actualitzem el mutable per actualitzar la vista
            this.currentWordMutableLiveData.setValue(word);
        } */
    }

    public void onClickedAtCard(CardEnum c, int id){
        Log.d(TAG, "onClickedAtCard ->" + CardEnum.getMessageResource(c));
        Log.d(TAG, "onClickedAtCard ->" + String.valueOf(id));
        // @Jordi: Això hauria de ser un setter i obtenir word amb un getter a la classe
        String word = game.concatenarLletres(c.toString());
        // @Jordi: Actualitzem el mutable per actualitzar la vista
        this.currentWordMutableLiveData.setValue(word);

        //TODO: @Didac segons el id d'on es cliqui, es mostrara o no
        this.showCard(id);


    }

    private void showCard(int id) {

        if(game.getParaulaUsuari().length() < 6) {

            if (id == 1) faceUpCardLletra1.setValue(true);
            else if (id == 2) faceUpCardLletra2.setValue(true);
            else if (id == 3) faceUpCardLletra3.setValue(true);
            else if (id == 4) faceUpCardLletra4.setValue(true);
            else if (id == 5) faceUpCardLletra5.setValue(true);
            else if (id == 6) faceUpCardLletra6.setValue(true);
            else if (id == 7) faceUpCardLletra7.setValue(true);
            else if (id == 8) faceUpCardLletra8.setValue(true);

            else faceUpCard.setValue(true);
        } else {
            game.setParaulaUsuari("");
            this.currentWordMutableLiveData.setValue("");

            faceUpCardLletra1.setValue(false);
            faceUpCardLletra2.setValue(false);
            faceUpCardLletra3.setValue(false);
            faceUpCardLletra4.setValue(false);
            faceUpCardLletra5.setValue(false);
            faceUpCardLletra6.setValue(false);
            faceUpCardLletra7.setValue(false);
            faceUpCardLletra8.setValue(false);

            temporitzadorObrir();

            //TODO: MOSTRAR TOAST QUAN L'USUARI NO ENCERTA PARAULA
            //gameActivity.alertaError();


        }
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        // Picasso.with(view.getContext()).setLoggingEnabled(true);
        Picasso.with(view.getContext()).load(imageUrl).into(view);
    }

    private Enum CardIdEnum; {


    }

}

