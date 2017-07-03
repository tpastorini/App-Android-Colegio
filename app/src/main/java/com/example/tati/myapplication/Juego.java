package com.example.tati.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_colores);

        nombreAppBar();
        callVolverAtras();
        callVerColores();
        callVerMezclador();
    }

    public void nombreAppBar(){
        TextView toolbar = (TextView) findViewById(R.id.titulo_app_bar);
        toolbar.setText("Juega con colores");
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

    public void callVerColores(){
        final CardView ver_colores = (CardView) findViewById(R.id.boton_colores);

        ver_colores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity_parte_colores.class);
                startActivityForResult(intent,0);
            }
        });
    }

    public void callVerMezclador(){
        final CardView ver_mezclador = (CardView) findViewById(R.id.boton_mezclador);

        ver_mezclador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity_parte_mezclador.class);
                startActivityForResult(intent,0);
            }
        });
    }
}
