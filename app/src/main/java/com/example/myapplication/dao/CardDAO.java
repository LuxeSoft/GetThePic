package com.example.myapplication.dao;

import com.example.myapplication.models.Card;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CardDAO {

    @GET("cards")
    Call<Card> getCard();

    @GET("cards/show")
    Call<Card> showCARD();

    @POST("cards/add")
    Call<Card> addCard();

}
