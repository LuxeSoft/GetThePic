package com.example.myapplication.repositories;

import android.util.Log;

import com.example.myapplication.dao.CardDAO;
import com.example.myapplication.dao.CardDAOimpl;
import com.example.myapplication.models.Card;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardRepo {

    private String TAG = "CardRepo";

    private CardDAO cardDAO;

    public CardRepo() {
        Log.d(TAG, "CArdRepo init");
        this.cardDAO = new CardDAOimpl();
        Log.d(TAG, "CArdRepo fin");
    }

    public void getCard(){

        cardDAO.getCard().enqueue(new Callback<Card>() {
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

        cardDAO.showCard(letter).enqueue(new Callback<Card>() {
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
