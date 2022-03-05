package com.example.myapplication.models;

public class Player {
    private String name;
    private int points;
    private int wins;
    private String password;
    private int xp;
    private int PicCoins;

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCoins() {
        return PicCoins;
    }

    public void setCoins(int coins) {
        this.PicCoins = coins;
    }

    public Player(String name, int xp, int wins) {
        this.name = name;
        this.points = points;
        this.wins = wins;
    }

    public void sumarXP(){
        this.xp += 100;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /** agafar dades dels usuaris
     * en aquesta pantalla agafarem les dades de l'usuari actual mitjançant
     * el seu registre a la bbdd
     * @param name
     * @param points
     * @param wins
     * @param password
     * @param PicCoins
     * @param xp
     * @return
     * @see
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
