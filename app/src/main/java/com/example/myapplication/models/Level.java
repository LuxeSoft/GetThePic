package com.example.myapplication.models;

import com.example.myapplication.repositories.LevelRepository;

import java.util.ArrayList;
import java.util.List;

public class Level {

    // Attributes
    private String solution;
    private List<CardEnum> letters;
    private String imageUrl;

    // Constructors
    public Level(){
        this.solution = "";
        this.letters = new ArrayList<>();
    }

    // Getters and Setters
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public List<CardEnum> getLetters() {
        return letters;
    }

    public void setLetters(List<CardEnum> letters) {
        this.letters = letters;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Level{" +
                "solution='" + solution + '\'' +
                ", letters=" + letters +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String maskSolution(){
        String masked = "";
        for(int i=0; i<this.solution.length(); i++){
            masked += "_ ";
        }
        return masked;
    }

}