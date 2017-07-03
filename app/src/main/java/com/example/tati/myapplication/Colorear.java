package com.example.tati.myapplication;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Colorear extends AppCompatActivity {

    Lienzo l;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorear);

        l = (Lienzo) findViewById(R.id.lienzo);

        nombreAppBar();
        callVolverAtras();
        borrar();
        cambiarColor();
    }

    public void nombreAppBar(){
        TextView toolbar = (TextView) findViewById(R.id.titulo_app_bar);
        toolbar.setText("Colorea");
    }

    public void callVolverAtras(){

        // Localizamos el botón en la vista
        final ImageButton atras = (ImageButton) findViewById(R.id.boton_atras);

        // Creamos el Listener
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                setContentView(R.layout.activity_main);
                finish();
            }
        });
    }

    public void borrar() {
        final ImageButton goma = (ImageButton) findViewById(R.id.goma_float);

        // Creamos el Listener
        goma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                l.setPaintColor(Color.WHITE);
            }
        });
    }

    public void callFlotantePaleta() {
        final ImageButton paleta = (ImageButton) findViewById(R.id.paleta_float);

        // Creamos el Listener
        paleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.setPaintColor(Color.CYAN);
            }
        });

    }

    public void cambiarColor() {

        final ImageButton paleta = (ImageButton) findViewById(R.id.paleta_float);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        final DialogoPersonalizado d = new DialogoPersonalizado();

        d.setD(null, this);

        paleta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                d.show(fragmentManager, "elige");
            }
        });

    }

    public void setColor(int c) {
        color = c;
        l.setPaintColor(color);
    }
}
