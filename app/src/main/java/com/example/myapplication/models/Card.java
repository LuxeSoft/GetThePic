package com.example.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("letter")
    private int letter;

    @SerializedName("image_letter")
    private String image_letter;

    @SerializedName("card_url")
    private String card_url;

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }

    public String getImage_letter() {
        return image_letter;
    }

    public Card(int letter, String image_letter, String card_url) {
        this.letter = letter;
        this.image_letter = image_letter;
        this.card_url = card_url;
    }

    public void setImage_letter(String image_letter) {
        this.image_letter = image_letter;
    }

    public String getCard_url() {
        return card_url;
    }

    public void setCard_url(String card_url) {
        this.card_url = card_url;
    }


}
