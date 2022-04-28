package com.example.myapplication.dao;

import com.example.myapplication.models.Imatge;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ImatgeDAO {

    @GET("imatges/show/nivell")
    Call<Imatge> showImatgeByLevel();

    @GET("imatges/show")
    Call<Imatge> showImatgeByName();

}
