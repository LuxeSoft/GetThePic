//package com.example.myapplication;
//
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.myapplication.databinding.ActivityLevelsBinding;
//import com.example.myapplication.models.CardEnum;
//import com.example.myapplication.models.Game;
//import com.example.myapplication.models.Player;
//import com.example.myapplication.viewModel.GameViewModel;
//import com.example.myapplication.views.FirstLevelView;
//
//public class Levels extends AppCompatActivity implements FirstLevelView {
//
//    private TextView tv; //textview on posem la paraula q va escrivint l'usuari
//    private TextView user_tv; //textview on posem nomusuari
//    private TextView xp_tv; //textview on posem xp usuari
//    private ImageView imgParaula; //imageView de la paraula de la imatge en endivinar
//
//    public static ImageView l1;
//    public static ImageView l2;
//    public static ImageView l3;
//    public static ImageView l4;
//    public static ImageView l5;
//    public static ImageView l6;
//    public static ImageView l7;
//    public static ImageView l8;
//
//
//    //-----------------------
//    public static int nivell = 1;
//
//    private GameViewModel viewModel;
//    Game game;
//    Player p1;
//
//    /** public void onCreate()
//     * Aquest metode restableix els valors de la partida.
//     * @param savedInstanceState
//     * @return void
//     */
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ActivityLevelsBinding firstLevelBinding = DataBindingUtil.setContentView(this, R.layout.activity_levels);
//
//        viewModel = new GameViewModel();
//        game = new Game();
//        tv = (TextView) findViewById(R.id.paraulaEscrita);
//        user_tv = (TextView)findViewById(R.id.user_tv);
//        xp_tv = (TextView) findViewById(R.id.xp_tv);
//        imgParaula = (ImageView)findViewById(R.id.imgParaula);
//        l1 = (ImageView)findViewById(R.id.l1);
//        l2 = (ImageView)findViewById(R.id.l2);
//        l3 = (ImageView)findViewById(R.id.l3);
//        l4 = (ImageView)findViewById(R.id.l4);
//        l5 = (ImageView)findViewById(R.id.l5);
//        l6 = (ImageView)findViewById(R.id.l6);
//        l7 = (ImageView)findViewById(R.id.l7);
//        l8 = (ImageView)findViewById(R.id.l8);
//        p1 = new Player("user1", "1234",0,0,0);
//
//        viewModel.bind(this);
//        viewModel.initPartida(); //inicialitzar lletres
//        game.setParaulaModel("arbre");
//        tv.setText("");
//        user_tv.setText(p1.getUsername());
//        xp_tv.setText(String.valueOf(p1.getXp()));
//
//        firstLevelBinding.setGameViewModel(viewModel);
//
//        viewModel.setGame(game);
//
//        // Get Card from Retrofit
//        viewModel.getCard();
//
//    }
//
//    /**
//     * mostrarLLetra ens defineix, al textview, la paraula q va introduint l'usuari. la
//     * paraula es va concatenant lletra x lletra
//     * @param  CardEnum c  la carta q apreta el usuari
//     * @return  void
//     */
//    @Override
//    public void mostrarLletra(CardEnum c) {
//
//        Log.d("onclick",c.toString());
//
//        String paraula = game.concatenarLletres(c.toString());
//
//        Log.d("onclick",paraula);
//
//        tv.setText(paraula);
//
//
//    }
//
//    /**
//     * getter per obtenir paraula q ha introduit l'usuari
//     * @return  valor del textview q s'ha ant escrivint
//     */
//
//    @Override
//    public String getParaula(){
//        return tv.getText().toString();
//    }
//
//    /**
//     * showMessage ens mostrara si l'usuari ha encertat o no la paraula q ha escrit
//     * @param  semafor  la paraula introduida x lusuari coincideix amb la paraula model? true/false
//     * @param  name the location of the image, relative to the url argument
//     * @return      void
//     */
//
//    @Override
//    public void showMessage(boolean semafor){
//
//        /*Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();*/
//
//        int duration = Toast.LENGTH_SHORT; // toast
//        Context context = getApplicationContext();// toast
//        AlertDialog.Builder builder = new AlertDialog.Builder(this); //alerta de quan guanya o perd
//
//        if (semafor == true){
//            Toast toast = Toast.makeText(context, "ENHORABONA! :)", duration);
//            toast.show();
//
//            builder.setTitle("Paraules iguals!");
//            builder.setMessage("Has obtingut +100 punts de xp");
//            p1.sumarXP();
//            xp_tv.setText(String.valueOf(p1.getXp()));
//
//            builder.setPositiveButton("continuar jugant", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                   //començar nova activitat amb següent nivell------------------------
//                    nivell = nivell+1;
//                    if (nivell == 2) {
//                        tv.setText("");
//                        game.borrarParaulaUsuari();
//                        viewModel.initPartida(); //inicialitzar lletres
//                        imgParaula.setImageResource(R.drawable.taula);
//                        game.setParaulaModel("taula");
//                        user_tv.setText(p1.getUsername());
//                        xp_tv.setText(String.valueOf(p1.getXp()));
//                        viewModel.setGame(game);
//                    }
//                }
//            });
//
//            builder.setNegativeButton("tornar al menú principal", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    startActivity(new Intent(Levels.this,MainActivity.class));
//                }
//            });
//            AlertDialog dialog = builder.create();
//            dialog.show();
//
//        } else {
//            Toast toast = Toast.makeText(context, "LLASTIMA! :(", duration);
//            toast.show();
//            builder.setTitle("No has endevinat la foto :(");
//            builder.setMessage("Que vols fer?");
//
//            builder.setPositiveButton("tornar a intentar", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    tv.setText("");
//                    game.borrarParaulaUsuari();
//                }
//            });
//
//            builder.setNegativeButton("tornar al menú principal", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    startActivity(new Intent(Levels.this,MainActivity.class));
//                }
//            });
//            AlertDialog dialog = builder.create();
//            dialog.show();
//
//        }
//
//    }
//
//}