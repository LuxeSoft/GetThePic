package com.example.myapplication.dao;

import android.util.Log;

import com.example.myapplication.models.Card;
import com.example.myapplication.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CardDAOimpl implements CardDAO {

    private  Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Card> getCard() {
        return retrofit.create(CardDAO.class).getCard();
    }

    @Override
    public Call<Card> showCard(String letter) {
        return retrofit.create(CardDAO.class).showCard(letter);
    }

    @Override
    public Call<List<Card>> getListCards(String imatge) {
        return retrofit.create(CardDAO.class).getListCards(imatge);
    }
}
