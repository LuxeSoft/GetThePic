package com.example.myapplication.repositories;

import android.util.Log;

import com.example.myapplication.dao.CardDAO;
import com.example.myapplication.dao.CardDAOimpl;
import com.example.myapplication.dao.PlayerDAO;
import com.example.myapplication.dao.PlayerDAOimpl;
import com.example.myapplication.models.Card;
import com.example.myapplication.models.Player;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerRepo {

    private String TAG = "PlayerRepo";

    private PlayerDAO playerDAO;

    public PlayerRepo() {
        Log.d(TAG, "PlayerRepo init");
        this.playerDAO = new PlayerDAOimpl();
        Log.d(TAG, "PlayerRepo fin");
    }

    public void getCard(){

        playerDAO.getCard().enqueue(new Callback<Card>() {
            @Override
            public void onResponse(Call<Card> call, Response<Card> response) {
                int code = response.code();
                Log.d("codi", String.valueOf(code));

                if (code == 200){
                    //correcte
                    Card c = response.body();
                    Log.d("getcard", c.getCard_url());
                }
            }

            @Override
            public void onFailure(Call<Card> call, Throwable t) {
                Log.d("cardrepoerror", t.getMessage());
            }
        });
    }


    public void showCard(String letter) {

        playerDAO.showCard(letter).enqueue(new Callback<Card>() {
            @Override
            public void onResponse(Call<Card> call, Response<Card> response) {
                int code = response.code();
                if (code==200) {
                    Card c = response.body();
                    Log.d("getcard", c.getCard_url());

                }

            }

            @Override
            public void onFailure(Call<Card> call, Throwable t) {
                Log.d("cardrepoerror", t.getMessage());
            }
        });
    }
}
