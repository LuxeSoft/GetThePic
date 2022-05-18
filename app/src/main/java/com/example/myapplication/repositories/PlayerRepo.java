package com.example.myapplication.repositories;

import android.util.Log;

import com.example.myapplication.dao.PlayerDAO;
import com.example.myapplication.dao.PlayerDAOimpl;
import com.example.myapplication.models.Player;
import com.example.myapplication.viewModel.SingInViewModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerRepo {
        private String TAG = "PlayerRepo";
        private SingInViewModel singInViewModel;

    private PlayerDAO playerDAO;

    public PlayerRepo(SingInViewModel singInViewModel) {
        Log.d(TAG, "PlayerRepo init");
        this.playerDAO = new PlayerDAOimpl();
        Log.d(TAG, "PlayerRepo fin");
        this.singInViewModel = singInViewModel;

    }

    /*public void getPlayers(){

        playerDAO.getPlayers().enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                int code = response.code();
                Log.d("codi", String.valueOf(code));

                if (code == 200){
                    //correcte
                  Player p = response.body();
                    Log.d("getplayers", p.getUsername());
                }
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.d("playerrepoerror", t.getMessage());
            }
        });
    }*/

    //TODO: @Didac Per a que us quedi més net, podeu anar borrant missatges de Log un cop ja vegueu que funciona bé.
    public void addPlayer(Player p){

        playerDAO.addPlayer(p).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("tag", "addplayer");
                Log.d("tag2", response.message());
                Log.d("codi", String.valueOf(response.code()));

                if(response.code()==200){
                    singInViewModel.iscreated.setValue(true);
                } else {
                    singInViewModel.iscreated.setValue(false);

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("error", t.getMessage());

            }
        });
    }
}