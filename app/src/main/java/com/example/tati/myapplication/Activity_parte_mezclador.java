package com.example.tati.myapplication;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_parte_mezclador extends AppCompatActivity {

    public static ImageButton c1;
    public static ImageButton c2;
    public static ImageView res;
    FragmentManager fragmentManager;
    DialogP d;

    public static int[] color_1 = {0,0,0}, color_2 = {0,0,0};
    public static COLORES C1 = COLORES.Rojo, C2 = COLORES.Amarillo;
    static  int llamada = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte_mezclador);

        c1 = (ImageButton) findViewById(R.id.color_1);
        c2 = (ImageButton) findViewById(R.id.color_2);
        res = (ImageView) findViewById(R.id.resultado);

        fragmentManager = getSupportFragmentManager();
        d = new DialogP();

        c1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                llamada=0;
                d.show(fragmentManager, "elige");
            }
        });

        c2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                llamada=1;
                d.show(fragmentManager, "elige");
            }
        });

        res.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                generarResultado();
            }
        });

        nombreAppBar();
        callVolverAtras();
    }

    public void nombreAppBar(){
        TextView toolbar = (TextView) findViewById(R.id.titulo_app_bar);
        toolbar.setText("Mezcla los colores");
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

    public static void  cambio1(int[] c,COLORES colores){
        if(llamada == 0){
            Activity_parte_mezclador.color_1[0] = c[0];
            Activity_parte_mezclador.color_1[1] = c[1];
            Activity_parte_mezclador.color_1[2] = c[2];
            c1.setBackgroundColor(Color.rgb(color_1[0],color_1[1],color_1[2]));
            C1 = colores;
            generarResultado();

        }else{
            Activity_parte_mezclador.color_2[0] = c[0];
            Activity_parte_mezclador.color_2[1] = c[1];
            Activity_parte_mezclador.color_2[2] = c[2];

            c2.setBackgroundColor(Color.rgb(color_2[0],color_2[1],color_2[2]));
            C2 = colores;
            generarResultado();
        }
    }

    public static void generarResultado(){
        // obtener colores de los botones pulsados

        switch (C1){
            case Azul:
                switch (C2){
                    case Azul:
                        res.setBackgroundColor(Color.rgb(0,0,255));
                        break;
                    case Amarillo:
                        res.setBackgroundColor(Color.rgb(0,255,0));
                        break;
                    case Rojo:
                        res.setBackgroundColor(Color.rgb(150,0,255));
                        break;
                    case Verde:
                        res.setBackgroundColor(Color.rgb(0,255,255));
                        break;
                }break;

            case Amarillo:
                switch (C2){
                    case Azul:
                        res.setBackgroundColor(Color.rgb(0,255,0));
                        break;
                    case Amarillo:
                        res.setBackgroundColor(Color.rgb(255,255,0));
                        break;
                    case Rojo:
                        res.setBackgroundColor(Color.rgb(244,70,17));
                        break;
                    case Verde:
                        res.setBackgroundColor(Color.rgb(87,166,57));
                        break;

                }break;

            case Rojo:
                switch (C2){
                    case Azul:
                        res.setBackgroundColor(Color.rgb(150,0,255));
                        break;
                    case Amarillo:
                        res.setBackgroundColor(Color.rgb(244,70,17));
                        break;
                    case Rojo:
                        res.setBackgroundColor(Color.rgb(255,0,0));
                        break;
                    case Verde:
                        res.setBackgroundColor(Color.rgb(255,255,0));
                        break;

                }break;

            case Verde:
                switch (C2){
                    case Azul:
                        res.setBackgroundColor(Color.rgb(0,255,255));
                        break;
                    case Amarillo:
                        res.setBackgroundColor(Color.rgb(87,166,57));
                        break;
                    case Rojo:
                        res.setBackgroundColor(Color.rgb(255,255,0));
                        break;
                    case Verde:
                        res.setBackgroundColor(Color.GREEN);
                        break;
                }break;
        }
    }
}
