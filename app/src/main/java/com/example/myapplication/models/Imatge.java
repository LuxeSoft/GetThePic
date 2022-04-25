package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Imatge {

    @SerializedName("nom_imatge")
    private String nom_imatge;

    @SerializedName("imatge_nivell")
    private String imatge_nivell;

    @SerializedName("nivell")
    private int nivell;

    public Imatge(String nom_imatge, String imatge_nivell, int nivell) {
        this.nom_imatge = nom_imatge;
        this.imatge_nivell = imatge_nivell;
        this.nivell = nivell;
    }

    public String getNom_imatge() {
        return nom_imatge;
    }

    public void setNom_imatge(String nom_imatge) {
        this.nom_imatge = nom_imatge;
    }

    public String getImatge_nivell() {
        return imatge_nivell;
    }

    public void setImatge_nivell(String imatge_nivell) {
        this.imatge_nivell = imatge_nivell;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
}
