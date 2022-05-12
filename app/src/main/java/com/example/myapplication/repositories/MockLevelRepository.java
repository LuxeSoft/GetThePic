package com.example.myapplication.repositories;

import static com.example.myapplication.models.CardEnum.a;
import static com.example.myapplication.models.CardEnum.b;
import static com.example.myapplication.models.CardEnum.c;
import static com.example.myapplication.models.CardEnum.ct;
import static com.example.myapplication.models.CardEnum.e;
import static com.example.myapplication.models.CardEnum.l;
import static com.example.myapplication.models.CardEnum.m;
import static com.example.myapplication.models.CardEnum.n;
import static com.example.myapplication.models.CardEnum.o;
import static com.example.myapplication.models.CardEnum.r;
import static com.example.myapplication.models.CardEnum.s;
import static com.example.myapplication.models.CardEnum.x;

import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Level;

import java.util.Arrays;
import java.util.Random;

//@TODO: Implementar aquesta interficies per obtenir el nivell de l'API
public class MockLevelRepository implements LevelRepository{


    // @Jordi Simulem que tenim una base de dades de nivells

    // Url de les imatges de cada nivell
    final String[] mockLevelImages = {
            "https://image.shutterstock.com/image-illustration/treejpg-eps-vector-version-id-260nw-122687560.jpg",
            "https://cdn.pixabay.com/photo/2019/10/13/20/07/house-4547140_1280.jpg",
            "https://dictionary.cambridge.org/es/images/thumb/lion_noun_002_21358.jpg?version=5.0.239"
    };
    // Lletres que es fan servir per solucionar el nivell
    final CardEnum[][] mockLevelLetters = {
            {a,x,e,b,r,m,n,ct},
            {a,c,e,b,r,s,n,a},
            {a,l,e,b,r,l,n,o}
    };
    // Solució esperada de cada nivell
    final String[] mockLevelSolutions ={"arbre","casa","lleo"};


    @Override
    public Level getLevel() {

        // Generem un nombre aleatori per seleccionar el nivell
        Random rand=new Random();
        int levelPosition = rand.nextInt(mockLevelImages.length);

        // Instanciem el nivell a partir de les dades simulades
        Level selectedLevel = new Level();
        selectedLevel.setLetters( Arrays.asList(mockLevelLetters[levelPosition]));
        selectedLevel.setSolution(mockLevelSolutions[levelPosition]);
        selectedLevel.setImageUrl(mockLevelImages[levelPosition]);

        // Retornem la instancia del nivell generat
        return selectedLevel;
    }
}