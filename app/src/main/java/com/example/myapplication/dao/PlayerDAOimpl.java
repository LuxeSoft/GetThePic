package com.example.myapplication.dao;

import com.example.myapplication.models.Player;
import com.example.myapplication.network.RetrofitClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;

public class PlayerDAOimpl implements PlayerDAO {
    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Player> getPlayers() {
        return retrofit.create(PlayerDAO.class).getPlayers();
    }

    @Override
    public Call<Player> getPlayersByUsername() {
        return retrofit.create(PlayerDAO.class).getPlayersByUsername();
    }

    @Override
    public Call<ResponseBody> addPlayer(Player player) {
        return retrofit.create(PlayerDAO.class).addPlayer(player);
    }
}
