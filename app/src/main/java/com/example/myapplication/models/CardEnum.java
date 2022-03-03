package com.example.myapplication.models;


import com.example.myapplication.R;
import com.example.myapplication.R.drawable;
import java.util.Random;

public enum CardEnum {
    a,
    r,
    b,
    e;
    //TOT ABECEDARI

    public static CardEnum getRandomCard() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    public static String getMessageResource(CardEnum e){


        switch(e){

            case a:
                return "a";
            case r:
                return "r";
            case b:
                return "b";
            case e:
                return "e";
            default:
                return "";
        }
    }

    public static int getCardResource(CardEnum e){

        switch(e){
            case a:
                return drawable.a;
            case b:
                return drawable.b;
            case r:
                return drawable.r;
            case e:
                return drawable.e;
            default:
                return -1;
        }

    }


}
