package com.example.myapplication.dao;

import com.example.myapplication.models.Card;
import com.example.myapplication.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CardDAOimpl implements CardDAO {

    private  Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Card> getCard() {
        return retrofit.create(CardDAO.class).getCard();
    }

    @Override
    public Call<Card> addCard(){
        return retrofit.create(CardDAO.class).addCard();
    }

    @Override
    public Call<Card> showCARD(){
        return retrofit.create(CardDAO.class).showCARD();
    }
}
