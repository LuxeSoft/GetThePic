package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("token")
    private String token;


    public Account(){
        this.token = "";
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "Account{" +
                "token='" + token + '\'' +
                '}';
    }
}
