package com.example.lab_0006;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button grafCircular = findViewById(R.id.buttonNuevo);
        Button grafBarras = findViewById(R.id.buttonInfoPostulante);

        grafCircular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNuevo = new Intent(MainActivity.this, ActivityCircular.class);
                startActivity(intentNuevo);
            }
        });

        grafBarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNuevo2 = new Intent(MainActivity.this, ActivityBarras.class);
                startActivity(intentNuevo2);
            }
        });


        ArrayList<Country> listCountries = Country.countries;

        listCountries.add(new Country("Argentina", 20.7f,"#C82A54"));
        listCountries.add(new Country("Bolivia", 46.6f, "#EF280F"));
        listCountries.add(new Country("Brazil", 28.6f, "#8C4966"));
        listCountries.add(new Country("Canada", 14.5f, "#109DFA"));
        listCountries.add(new Country("Chile", 23.4f, "#FF689D"));
        listCountries.add(new Country("Colombia", 27.4f,"#02AC66"));
        listCountries.add(new Country("Ecuador", 32.9f, "#E36B2C"));
        listCountries.add(new Country("Guyana", 28.3f, "#E7D40A"));
        listCountries.add(new Country("Mexico", 29f, "#6DC36D"));
        listCountries.add(new Country("Paraguay", 34.8f, "#024A86"));
        listCountries.add(new Country("Peru", 32.9f, "#222222"));
        listCountries.add(new Country("U.S.A", 16.7f, "#BBA9BB"));
        listCountries.add(new Country("Uruguay", 18f, "#E3632A"));
        listCountries.add(new Country("Venezuela", 27.5f,"#E9A4C7"));
        //listCountries.add(new Country("Prueba1", 25.5f,"#A2DCFF"));
        //listCountries.add(new Country("Prueba2", 15.4f,"#99FFAA"));


    }
}