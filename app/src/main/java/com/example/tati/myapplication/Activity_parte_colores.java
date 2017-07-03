package com.example.tati.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity_parte_colores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte_colores);

        nombreAppBar();
        callMostrarColores();
        callVolverAtras();
    }

    public void nombreAppBar(){
        TextView toolbar = (TextView) findViewById(R.id.titulo_app_bar);
        toolbar.setText("Aprende los colores");
    }

    public void callVolverAtras(){

        // Localizamos el botón en la vista
        final ImageButton atras = (ImageButton) findViewById(R.id.boton_atras);

        // Creamos el Listener
        atras.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                setContentView(R.layout.activity_juego_colores);
                finish();
            }
        });
    }

    public void callMostrarColores(){
        GridView gridView = (GridView) findViewById( R.id.grid_colores );
        gridView.setAdapter( new AdaptadorColores(this) );
    }

}
