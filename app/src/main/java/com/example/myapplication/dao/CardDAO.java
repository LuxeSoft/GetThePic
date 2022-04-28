package com.example.myapplication.dao;

import com.example.myapplication.models.Card;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CardDAO {

    @GET("cards")
    Call<Card> getCard();

    @GET("cards/list/{imatge}")
    Call<List<Card>> getListCards(@Path("imatge") String imatge);

    @GET("cards/show/{letter}")
    Call<Card> showCard(@Path("letter") String letter);


}
