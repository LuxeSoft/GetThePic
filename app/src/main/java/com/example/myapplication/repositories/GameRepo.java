package com.example.myapplication.repositories;

import android.util.Log;

import com.example.myapplication.dao.GameDAO;
import com.example.myapplication.dao.GameDAOimpl;
import com.example.myapplication.models.Game;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameRepo {
    private String TAG = "GameRepo";

    private GameDAO gameDAO;

    public GameRepo() {
        Log.d(TAG, "CArdRepo init");
        this.gameDAO = new GameDAOimpl();
        Log.d(TAG, "CArdRepo fin");
    }

    public void guardarPartida(){
        this.gameDAO.savePartida().enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {
                int code = response.code();
                Log.d("codi", String.valueOf(code));

                if (code == 200) {
                    //correcte
                    Game g = response.body();
                    Log.d("idPartida", g.getId_partida());
                }
            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {
                Log.d("gamerepoerror", t.getMessage());
            }
        });
    }
}
