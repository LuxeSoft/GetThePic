package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("username")
    private String username;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("pic_coins")
    private int pic_coins;

    @SerializedName("wins")
    private int wins;

    @SerializedName("xp")
    private int xp;

    public Player(String username, String email, String password, int pic_coins, int wins, int xp) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.pic_coins = pic_coins;
        this.wins = wins;
        this.xp = xp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPic_coins() {
        return pic_coins;
    }

    public void setPic_coins(int pic_coins) {
        this.pic_coins = pic_coins;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    /** public void sumarXP()
     * Aquest metode suma 100 d'experiencia a l'experiencia de l'usuari.
     * @param
     * @return l'experiencia.
     * @see
     */
    public void sumarXP(){
        this.xp += 100;
    }


}
