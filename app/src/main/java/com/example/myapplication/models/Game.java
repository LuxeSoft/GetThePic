package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Game {

    private Player actualUser;
    private String paraulaModel;
    private String paraulaUsuari;

    @SerializedName("id_partida")
    private String id_partida;

    @SerializedName("username")
    private String username;

    @SerializedName("temps")
    private int temps;

    @SerializedName("guanyat")
    private boolean guanyat;

    public Game() {
        this.paraulaUsuari="";
    }

    public Player getActualUser() {
        return actualUser;
    }

    public void setActualUser(Player actualUser) {
        this.actualUser = actualUser;
    }

    public String getId_partida() {
        return id_partida;
    }

    public void setId_partida(String id_partida) {
        this.id_partida = id_partida;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public boolean isGuanyat() {
        return guanyat;
    }

    public void setGuanyat(boolean guanyat) {
        this.guanyat = guanyat;
    }

    public void borrarParaulaUsuari(){
        this.paraulaUsuari = "";
    }

    public void setParaulaModel(String paraula){
        paraulaModel = paraula;
    }

    public String getParaulaModel() {
        return this.paraulaModel;
    }

    public void setParaulaUsuari(String paraula) {
        this.paraulaUsuari = paraula;
    }

    public String getParaulaUsuari() {
        return this.paraulaUsuari;
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
}