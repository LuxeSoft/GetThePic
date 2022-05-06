package com.example.myapplication.dao;

import com.example.myapplication.models.Account;
import com.example.myapplication.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class AccountServiceImpl implements AccountService {

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Account> createTokenUser(String authorizationToken) {
        return retrofit.create(AccountService.class).createTokenUser(authorizationToken);
    }

}
