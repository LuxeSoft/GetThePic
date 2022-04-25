package com.example.myapplication.dao;

import com.example.myapplication.models.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlayerDAO {

    @GET("player")
    Call<Player> getPlayers();

    @GET("player/show")
    Call<Player> getPlayersByUsername();

    @POST("player/add")
    Call<Player> addPlayer();

}
