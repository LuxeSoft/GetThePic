package com.example.myapplication.dao;

import com.example.myapplication.models.Card;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CardDAO {

    @GET("cards")
    Call<Card> getCard();


    @GET("cards/show/{letter}")
    Call<Card> showCard(@Path("letter") String letter);

    @POST("cards/add") //TODO: DIDAC: No te sentit implementar el addCard. L'usuari no podrà crear una carta.
    Call<Card> addCard();

}
