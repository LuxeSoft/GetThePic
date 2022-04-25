package com.example.myapplication.dao;

import com.example.myapplication.models.Card;
import com.example.myapplication.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class cardDAOimpl implements cardDAO {

    private  Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Card> getRandomQuestion() {
        return retrofit.create(cardDAO.class).getRandomQuestion();
    }
}
