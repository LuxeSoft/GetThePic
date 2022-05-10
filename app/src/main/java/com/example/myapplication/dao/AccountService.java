package com.example.myapplication.dao;

import com.example.myapplication.models.Account;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AccountService {
    @POST("account/create_token")
    Call<Account> createTokenUser(@Header("Authorization") String authorizationToken);


}
