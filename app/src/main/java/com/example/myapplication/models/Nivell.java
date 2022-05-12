package com.example.myapplication.models;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Nivell {

    public int level;
    public String imatge;
    public ArrayList lletres;

    public ArrayList getLletres() {
        return lletres;
    }

    @Override
    public String toString() {
        return "Nivell{" +
                "level=" + level +
                ", imatge='" + imatge + '\'' +
                ", lletres=" + lletres +
                '}';
    }

    public void setLletres(ArrayList lletres) {
        this.lletres = lletres;
    }

    public int getLevel() {
        return level;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public void setLevel(int level) {
        this.level = level;
    }

//    @BindingAdapter({"bind:imageUrl"})
//    public static void loadImage(ImageView view, String imageUrl) {
//        Picasso.with(view.getContext()).load(imageUrl).into(view);
//    }
}