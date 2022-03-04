package com.example.myapplication.views;

import com.example.myapplication.models.CardEnum;

public interface FirstLevelView {
    void mostrarLletra(CardEnum c);
    String getParaula();
    void showMessage(boolean semafor);

}
