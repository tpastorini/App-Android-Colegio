package com.example.tati.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class DialogP  extends DialogFragment {

    ImageButton negro,rosa,azul;
    ImageButton verde,rojo,amarillo,violeta,naranja;

    int[] bits;
    int llamada;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Metemos el contenido que queremos ver en el dialogo
        final View v = inflater.inflate(R.layout.dialog_colores, null);

        // Asignamos el contenido (vista) al dialogo
        builder.setView(v);
        final Dialog dialog = builder.create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener(){
            @Override
            public void onShow(DialogInterface dialogInterface){

                azul = (ImageButton)v.findViewById(R.id.azul);
                rojo = (ImageButton)v.findViewById(R.id.rojo);
                amarillo = (ImageButton)v.findViewById(R.id.amarillo);
                violeta =(ImageButton)v.findViewById(R.id.violeta);
                verde = (ImageButton)v.findViewById(R.id.verde);
                naranja = (ImageButton)v.findViewById(R.id.naranja);
                rosa = (ImageButton)v.findViewById(R.id.rosa);
                negro = (ImageButton)v.findViewById(R.id.negro);
                negro.setVisibility(View.INVISIBLE);
                violeta.setVisibility(View.INVISIBLE);
                naranja.setVisibility(View.INVISIBLE);
                rosa.setVisibility(View.INVISIBLE);

                final Resources res = getResources();


                azul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        bits = res.getIntArray(R.array.AzulRGB);

                        Activity_parte_mezclador.cambio1(bits,COLORES.Azul);
                        dialog.dismiss();

                    }
                });

                rojo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton "color_1"
                        bits = res.getIntArray(R.array.RojoRGB);
                        Activity_parte_mezclador.cambio1(bits,COLORES.Rojo);

                        dialog.dismiss();

                    }
                });

                amarillo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton "color_1"
                        bits = res.getIntArray(R.array.AmarilloRGB);
                        Activity_parte_mezclador.cambio1(bits,COLORES.Amarillo);

                        dialog.dismiss();
                    }
                });



                verde.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton "color_1"
                        bits = res.getIntArray(R.array.VerdeRGB);

                        Activity_parte_mezclador.cambio1(bits,COLORES.Verde);
                        dialog.dismiss();
                    }
                });

            }

        });

        return dialog;


    }

    public void setColor(int c){
         llamada = c;
    }
}
