package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.myapplication.models.Game;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    Game game = new Game();


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2); //prova basica
    }

    @Test
    public void matchWord_isCorrect(){
        game.setParaulaUsuari("arbre");
        game.setParaulaModel("arbre");
        assertEquals(game.getParaulaModel(), game.getParaulaUsuari());
    }

    @Test
    public void matchWord2_isCorrect(){
        game.setParaulaUsuari("taula");
        game.setParaulaModel("arbre");
        assertEquals(game.getParaulaModel(), game.getParaulaUsuari());
    }
}