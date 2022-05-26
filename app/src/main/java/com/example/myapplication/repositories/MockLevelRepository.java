package com.example.myapplication.repositories;

import static com.example.myapplication.models.CardEnum.a;
import static com.example.myapplication.models.CardEnum.b;
import static com.example.myapplication.models.CardEnum.c;
import static com.example.myapplication.models.CardEnum.ct;
import static com.example.myapplication.models.CardEnum.d;
import static com.example.myapplication.models.CardEnum.e;
import static com.example.myapplication.models.CardEnum.f;
import static com.example.myapplication.models.CardEnum.g;
import static com.example.myapplication.models.CardEnum.h;
import static com.example.myapplication.models.CardEnum.i;
import static com.example.myapplication.models.CardEnum.j;
import static com.example.myapplication.models.CardEnum.k;
import static com.example.myapplication.models.CardEnum.l;
import static com.example.myapplication.models.CardEnum.m;
import static com.example.myapplication.models.CardEnum.n;
import static com.example.myapplication.models.CardEnum.o;
import static com.example.myapplication.models.CardEnum.p;
import static com.example.myapplication.models.CardEnum.q;
import static com.example.myapplication.models.CardEnum.r;
import static com.example.myapplication.models.CardEnum.s;
import static com.example.myapplication.models.CardEnum.t;
import static com.example.myapplication.models.CardEnum.u;
import static com.example.myapplication.models.CardEnum.v;
import static com.example.myapplication.models.CardEnum.w;
import static com.example.myapplication.models.CardEnum.x;
import static com.example.myapplication.models.CardEnum.y;
import static com.example.myapplication.models.CardEnum.z;

import com.example.myapplication.models.CardEnum;
import com.example.myapplication.models.Level;
import com.example.myapplication.utils.PreferencesProvider;

import java.util.Arrays;
import java.util.Random;

//@TODO: Implementar aquesta interficies per obtenir el nivell de l'API
public class MockLevelRepository implements LevelRepository{

    Random rand=new Random();
    int levelPosition = 0;


    // @Jordi Simulem que tenim una base de dades de nivells

    // Url de les imatges de cada nivell
    final String[] mockLevelImages = {
            "https://cdn.pixabay.com/photo/2014/12/22/00/05/bread-576777_960_720.png",
            "https://cdn.pixabay.com/photo/2014/03/14/20/07/painting-287403_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/01/29/11/01/the-sun-2017530_1280.png",
            "https://cdn.pixabay.com/photo/2014/04/03/09/59/airplane-309503_960_720.png",
            "https://cdn.pixabay.com/photo/2014/08/19/12/14/flowers-421415_1280.png",
            "https://cdn.pixabay.com/photo/2019/10/13/20/07/house-4547140_1280.jpg",
            "https://dictionary.cambridge.org/es/images/thumb/lion_noun_002_21358.jpg?version=5.0.239",
            "https://cdn.pixabay.com/photo/2016/05/26/14/39/parrot-1417286_960_720.png",
            "https://image.shutterstock.com/image-illustration/treejpg-eps-vector-version-id-260nw-122687560.jpg",
            "https://cdn.pixabay.com/photo/2018/07/30/04/43/ice-cream-3571774_1280.png",
            "https://img.freepik.com/vector-gratis/icono-coche-rojo-vista-lateral-auto-dibujos-animados-lindo-aislado-sobre-fondo-blanco_176411-3164.jpg",
            "https://cdn.pixabay.com/photo/2013/07/13/13/34/football-161132_960_720.png",
            "https://cdn.pixabay.com/photo/2014/07/10/06/51/phone-388838_960_720.png",
            "https://img.freepik.com/free-photo/peach-table_144627-17512.jpg?t=st=1653148737~exp=1653149337~hmac=7e2746b46281dc1cf3fcaa28974e33d9616ac35dad46b5b3a0b468a46bfeaa82&w=740",
            "https://cdn.pixabay.com/photo/2013/07/12/15/34/shirt-150087_960_720.png"
    };
    // Lletres que es fan servir per solucionar el nivell
    final CardEnum[][] mockLevelLetters = {
            {n,e,a,b,p,r,d,c},
            {r,p,s,h,j,g,r,o},
            {j,l,w,s,a,u,o,z},
            {i,n,l,a,o,k,v,q},
            {q,o,r,e,l,w,t,f},
            {a,c,e,b,r,s,n,a},
            {a,l,e,b,r,l,n,o},
            {i,r,l,b,o,o,l,c},
            {a,x,e,b,r,m,n,r},
            {a,j,l,i,t,g,h,e},
            {c,e,o,t,r,x,w,e},
            {l,t,f,a,i,e,p,o},
            {f,e,t,l,n,l,o,e},
            {e,s,c,p,s,r,e,m},
            {t,i,a,s,e,m,c,a}
    };
    // Solució esperada de cada nivell
    final String[] mockLevelSolutions ={"pa",
            "gos","sol",
            "avio","flor","casa","lleo",
            "lloro","arbre","gelat","cotxe",
            "pilota","telefon","pressec","camiseta"};


    public String getMockLevelSolutions(int num) {
        return mockLevelSolutions[num];
    }


    public int getLevelPosition(){
        return this.levelPosition;
    }


    @Override
    public Level getLevel() {


        // Instanciem el nivell a partir de les dades simulades
        Level selectedLevel = new Level();

        this.levelPosition = rand.nextInt(mockLevelImages.length);

        PreferencesProvider.providePreferences().edit().putInt("randomNum", levelPosition).commit();


        selectedLevel.setLetters( Arrays.asList(mockLevelLetters[levelPosition]));
        selectedLevel.setSolution(mockLevelSolutions[levelPosition]);
        selectedLevel.setImageUrl(mockLevelImages[levelPosition]);

        // Retornem la instancia del nivell generat
        return selectedLevel;
    }


    @Override
    public Level getLevel(int levelPosition) {

        Level selectedLevel = new Level();


        if(levelPosition < mockLevelSolutions.length){

            // Generem un nombre aleatori per seleccionar el nivell

            // Instanciem el nivell a partir de les dades simulades

            selectedLevel.setLetters(Arrays.asList(mockLevelLetters[levelPosition]));
            selectedLevel.setSolution(mockLevelSolutions[levelPosition]);
            selectedLevel.setImageUrl(mockLevelImages[levelPosition]);

            // Retornem la instancia del nivell generat
        }
        return selectedLevel;

    }
}