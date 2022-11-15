package com.example.lab_0006;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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

    }
}