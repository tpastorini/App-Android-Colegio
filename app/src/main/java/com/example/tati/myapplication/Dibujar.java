package com.example.tati.myapplication;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Dibujar extends AppCompatActivity {

    private static int color = Color.BLUE;
    Lienzo l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujar);

        l = (Lienzo) findViewById(R.id.lienzo);

        nombreAppBar();
        callVolverAtras();
        cambiarColor();
        borrar();
    }

    public void nombreAppBar(){
        TextView toolbar = (TextView) findViewById(R.id.titulo_app_bar);
        toolbar.setText("Dibuja");
    }

    public void callVolverAtras() {

        // Localizamos el botón en la vista
        final ImageButton atras = (ImageButton) findViewById(R.id.boton_atras);

        // Creamos el Listener
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void borrar() {
        final ImageButton goma = (ImageButton) findViewById(R.id.goma_float);

        // Creamos el Listener
        goma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                l.setPaintColor(Color.WHITE);
            }
        });
    }

    public void cambiarColor() {

        final ImageButton paleta = (ImageButton) findViewById(R.id.paleta_float);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final DialogoPersonalizado d = new DialogoPersonalizado();

        d.setD(this, null);

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