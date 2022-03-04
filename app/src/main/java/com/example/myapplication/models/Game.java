package com.example.myapplication.models;

import android.provider.CalendarContract;

import androidx.lifecycle.MutableLiveData;

public class Game {
    private Player actualUser;
    private String paraulaUsuari;
    private String paraulaModel;

    public Game() {
        this.paraulaUsuari = "";
    }

    /** public void partida()
     * Aquest metode ens permetra iniciar a la partida i poder jugar
     * @param
     * @return
     * @see
     */


    public void partida(){
        //@TODO
        //funcio de recorrer lletra x lletra un string
        //relacionar string a corresponent enum
    }

    public String concatenarLletres(String lletra){
        return this.paraulaUsuari += lletra;
    }

    public String getParaulaUsuari() {
        return paraulaUsuari;
    }

    public void setParaulaUsuari(String paraulaUsuari) {
        this.paraulaUsuari = paraulaUsuari;
    }

    public String getParaulaModel() {
        return paraulaModel;
    }

    public void setParaulaModel(String paraulaModel) {
        this.paraulaModel = paraulaModel;
    }

    public Player getActualUser() {
        return actualUser;
    }

    public void setActualUser(Player actualUser) {
        this.actualUser = actualUser;
    }
}
