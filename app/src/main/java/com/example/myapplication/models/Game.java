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
    }

    /** public String concatenarLletres()
     * Aquest metode ens permetra concatenar les lletres que el jugador esta polsant per formar una paraula.
     * @param lletra, la lletra seleccionada.
     * @return un String, la paraula que l'usuari esta formant.
     * @see
     */
    public String concatenarLletres(String lletra){
        return this.paraulaUsuari += lletra;
    }

    /** public void borrarParaulaUsuari()
     * Aquest metode ens permetra esborrar la paraula que el jugador estaba creant.
     * @param
     * @return un String buit.
     * @see
     */
    public void borrarParaulaUsuari(){
        this.paraulaUsuari = "";
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
