package com.example.myapplication.models;


import com.example.myapplication.R;
import com.example.myapplication.R.drawable;
import java.util.Random;

public enum CardEnum {
    a,b,c,ct,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    //TOT ABECEDARI

    /** public static CardEnum getRandomCard()
     * Aquest metode ens permetra obtenir una carta de forma aleatoria.
     * @param
     * @return Una carta.
     * @see
     */
    public static CardEnum getRandomCard() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    /** public static String getMessageResource()
     * Aquest metode asigna una lletra (string) a cada carta.
     * @param e, la carta.
     * @return Un String, corresponent a la carta.
     * @see
     */
    public static String getMessageResource(CardEnum e){
        switch(e){

            case a:
                return "a";
            case b:
                return "b";
            case c:
                return "c";
            case ct:
                return "ç";
            case d:
                return "d";
            case e:
                return "e";
            case f:
                return "f";
            case g:
                return "g";
            case h:
                return "h";
            case i:
                return "i";
            case j:
                return "j";
            case k:
                return "k";
            case l:
                return "l";
            case m:
                return "m";
            case n:
                return "n";
            case o:
                return "o";
            case p:
                return "p";
            case q:
                return "q";
            case r:
                return "r";
            case s:
                return "s";
            case t:
                return "t";
            case u:
                return "u";
            case v:
                return "v";
            case w:
                return "w";
            case x:
                return "x";
            case y:
                return "y";
            case z:
                return "z";
            default:
                return "";
        }
    }

    /** public static int getCardResource()
     * Aquest metode ens permetra obtenir la imatge de la carta.
     * @param e, la carta.
     * @return la imatge de la carta.
     * @see
     */
    public static int getCardResource(CardEnum e){

        switch(e){
            case a:
                return drawable.a;
            case b:
                return drawable.b;
            case c:
                return drawable.c;
            case ct:
                return drawable.c_trencada;
            case d:
                return drawable.d;
            case e:
                return drawable.e;
            case f:
                return drawable.f;
            case g:
                return drawable.g;
            case h:
                return drawable.h;
            case i:
                return drawable.i;
            case j:
                return drawable.j;
            case k:
                return drawable.k;
            case l:
                return drawable.l;
            case m:
                return drawable.m;
            case n:
                return drawable.n;
            case o:
                return drawable.o;
            case p:
                return drawable.p;
            case q:
                return drawable.q;
            case r:
                return drawable.r;
            case s:
                return drawable.s;
            case t:
                return drawable.t;
            case u:
                return drawable.u;
            case v:
                return drawable.v;
            case w:
                return drawable.w;
            case x:
                return drawable.x;
            case y:
                return drawable.y;
            case z:
                return drawable.z;
            default:
                return -1;
        }

    }


}
