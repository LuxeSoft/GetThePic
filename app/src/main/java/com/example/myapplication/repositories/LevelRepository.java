package com.example.myapplication.repositories;

import com.example.myapplication.models.Level;

public interface LevelRepository {

    // Return an instance of a level
    public Level getLevel();
    public Level getLevel(int num);


}