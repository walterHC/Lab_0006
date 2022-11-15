package com.example.lab_0006;

import java.util.ArrayList;

public class Pais {
    private String nombre;
    private float tasaNatalidad;
    private String color;

    public static ArrayList<Pais> paises;

    Pais(String n, float tn, String c){
        this.nombre = n;
        this.tasaNatalidad=tn;
        this.color = c;
    }

    //Accesores
    public String getNombre(){
        return nombre;
    }

    public float getTasaNatalidad() {
        return tasaNatalidad;
    }

    public String getColor() {
        return color;
    }

    public static void generarListaPaises(){

        paises = new ArrayList<Pais>();

        paises.add(new Pais("Argentina", 20.7f,"#C82A54"));
        paises.add(new Pais("Bolivia", 46.6f, "#EF280F"));
        paises.add(new Pais("Brazil", 28.6f, "#8C4966"));
        paises.add(new Pais("Canada", 14.5f, "#109DFA"));
        paises.add(new Pais("Chile", 23.4f, "#FF689D"));
        paises.add(new Pais("Colombia", 27.4f,"#02AC66"));
        paises.add(new Pais("Ecuador", 32.9f, "#E36B2C"));
        paises.add(new Pais("Guyana", 28.3f, "#E7D40A"));
        paises.add(new Pais("Mexico", 29f, "#6DC36D"));
        paises.add(new Pais("Paraguay", 34.8f, "#024A86"));
        paises.add(new Pais("Peru", 32.9f, "#222222"));
        paises.add(new Pais("U.S.A", 16.7f, "#BBA9BB"));
        paises.add(new Pais("Uruguay", 18f, "#E3632A"));
        paises.add(new Pais("Venezuela", 27.5f,"#E9A4C7"));
        //paises.add(new Pais("Prueba1", 20.5f,"#A2DCFF"));
        //paises.add(new Pais("Prueba2", 15.0f,"#99FFAA"));

    }
}
