package com.example.myapplication.dao;

import com.example.myapplication.models.Game;
import com.example.myapplication.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class GameDAOimpl implements GameDAO {
    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Game> getPartida() {
        return retrofit.create(GameDAO.class).getPartida();
    }

    @Override
    public Call<Game> getPartidaById() {
        return retrofit.create(GameDAO.class).getPartidaById();
    }

    @Override
    public Call<Game> savePartida() {
        return retrofit.create(GameDAO.class).savePartida();
    }
}
