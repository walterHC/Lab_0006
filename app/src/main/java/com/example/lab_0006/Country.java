package com.example.lab_0006;

import java.util.ArrayList;

public class Country {
    private String name;
    private float birthRate;
    private String color;

    public static ArrayList<Country> countries = new ArrayList<Country>();

    Country(String n, float br, String c){
        this.name = n;
        this.birthRate = br;
        this.color = c;
    }

    //getter
    public String getName(){
        return name;
    }

    public float getBirthRate() {
        return birthRate;
    }

    public String getColor() {
        return color;
    }

}
