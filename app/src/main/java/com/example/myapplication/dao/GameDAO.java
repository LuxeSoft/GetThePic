package com.example.myapplication.dao;

import com.example.myapplication.models.Game;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GameDAO {

    @GET("partida")
    Call<Game> getPartida();

    @GET("partida")
    Call<Game> getPartidaById();

    @POST("partida")
    Call<Game> savePartida();

}
