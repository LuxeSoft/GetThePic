package com.example.myapplication.dao;

import com.example.myapplication.models.Card;

import retrofit2.Call;
import retrofit2.http.GET;

public interface cardDAO {

    //Exemple 1. Com obtenir una resposta aleatoria sense filtre.
    @GET("trivial/question")
    Call<Card> getRandomQuestion();

    //Exemple 2. Com obtenir una resposta filtrada per una categoria
}
