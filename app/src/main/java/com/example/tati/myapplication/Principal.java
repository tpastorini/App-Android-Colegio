package com.example.tati.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreAppBar();
        callDibujar();
        callColorear();
        callJuego();
        callSalir();
    }

    public void nombreAppBar(){
        TextView toolbar = (TextView) findViewById(R.id.titulo_app_bar);
        toolbar.setText("Juega con colores");
    }

    /////////////////// BOTON DE DIBUJAR ///////////////////

    public void callDibujar(){

        // Localizamos el botón en la vista
        final CardView dibujar = (CardView) findViewById(R.id.boton_dibujar);

        // Creamos el Listener
        dibujar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Dibujar.class);
                startActivityForResult(intent,0);
            }
        });
    }

    /////////////////// BOTON DE COLOREAR ///////////////////

    public void callColorear(){

        // Localizamos el botón en la vista
        final CardView colorear = (CardView) findViewById(R.id.boton_colorear);

        // Creamos el Listener
        colorear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Colorear.class);
                startActivityForResult(intent,0);
            }
        });
    }

    /////////////////// BOTON DE JUEGO ///////////////////

    public void callJuego(){
        final CardView jugar = (CardView) findViewById(R.id.boton_juego);

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Juego.class);
                startActivityForResult(intent,0);
            }
        });
    }

    /////////////////// BOTON DE SALIR ///////////////////

    public void callSalir(){

        // Localizamos el botón en la vista
        final CardView salir = (CardView) findViewById(R.id.boton_salir);

        // Creamos el Listener
        salir.setOnClickListener(new LinearLayout.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

}   // Fin de la clase
