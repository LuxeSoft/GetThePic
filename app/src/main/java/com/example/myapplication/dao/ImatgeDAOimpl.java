package com.example.myapplication.dao;

import com.example.myapplication.models.Imatge;
import com.example.myapplication.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ImatgeDAOimpl implements ImatgeDAO {

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Imatge> showImatgeByLevel() {
        return retrofit.create(ImatgeDAO.class).showImatgeByLevel();
    }

    @Override
    public Call<Imatge> showImatgeByName() {
        return retrofit.create(ImatgeDAO.class).showImatgeByName();
    }
}
