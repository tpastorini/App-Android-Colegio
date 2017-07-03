package com.example.tati.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;


public class DialogoPersonalizado extends DialogFragment{

    Dibujar d;
    Colorear c;
    ImageButton color1, color2;  // color que abre el dialogo
    int color_1, color_2; // colores que se sumarán para obtener el resultado

    Activity_parte_mezclador pm;

    int VIOLET = Color.parseColor("#9600ff");
    int ORANGE = Color.parseColor("#ff8100");
    int PINK = Color.parseColor("#ff81c8");

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Creamos el cuadro de dialogo y se situa encima del activity
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

                final ImageButton azul = (ImageButton)v.findViewById(R.id.azul);
                final ImageButton rojo = (ImageButton)v.findViewById(R.id.rojo);
                final ImageButton amarillo = (ImageButton)v.findViewById(R.id.amarillo);
                final ImageButton violeta =(ImageButton)v.findViewById(R.id.violeta);
                final ImageButton verde = (ImageButton)v.findViewById(R.id.verde);
                final ImageButton naranja = (ImageButton)v.findViewById(R.id.naranja);
                final ImageButton rosa = (ImageButton)v.findViewById(R.id.rosa);
                final ImageButton negro = (ImageButton)v.findViewById(R.id.negro);

                if(color1 != null || color2 != null){
                    negro.setVisibility(View.INVISIBLE);
                }

                azul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            pm.c1.setBackgroundColor(Color.BLUE);
                            azul.setVisibility(View.INVISIBLE);
                            color_1=Color.BLUE;
                            colorResultado();
                        }
                        else if(color2 != null){
                            pm.c2.setBackgroundColor(Color.BLUE);
                            azul.setVisibility(View.INVISIBLE);
                            color_2=Color.BLUE;
                            colorResultado();
                        }
                        else if(d != null)
                            d.setColor(Color.BLUE);
                        else
                            c.setColor(Color.BLUE);

                        dialog.dismiss();
                    }
                });

                rojo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            color1.setBackgroundColor(Color.RED);
                            rojo.setVisibility(View.INVISIBLE);
                            color_1=Color.YELLOW;
                            colorResultado();
                        }
                        else if(color2 != null){
                            color2.setBackgroundColor(Color.RED);
                            rojo.setVisibility(View.INVISIBLE);
                            color_2=Color.YELLOW;
                            colorResultado();
                        }
                        else if(d != null)
                            d.setColor(Color.RED);
                        else
                            c.setColor(Color.RED);

                        dialog.dismiss();
                    }
                });

                amarillo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            color1.setBackgroundColor(Color.YELLOW);
                            amarillo.setVisibility(View.INVISIBLE);
                            color_1=Color.YELLOW;
                            colorResultado();
                        }
                        else if(color2 != null){
                            color2.setBackgroundColor(Color.YELLOW);
                            amarillo.setVisibility(View.INVISIBLE);
                            color_2=Color.YELLOW;
                            colorResultado();
                        }
                        else if(d != null)
                            d.setColor(Color.YELLOW);
                        else
                            c.setColor(Color.YELLOW);

                        dialog.dismiss();
                    }
                });

                violeta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            color1.setBackgroundColor(VIOLET);
                            violeta.setVisibility(View.INVISIBLE);
                        }
                        else if(color2 != null){
                            color2.setBackgroundColor(VIOLET);
                            violeta.setVisibility(View.INVISIBLE);
                        }
                        else if(d != null)
                            d.setColor(VIOLET);
                        else
                            c.setColor(VIOLET);

                        dialog.dismiss();
                    }
                });

                verde.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            color1.setBackgroundColor(Color.GREEN);
                            verde.setVisibility(View.INVISIBLE);
                        }
                        else if(color2 != null){
                            color2.setBackgroundColor(Color.GREEN);
                            verde.setVisibility(View.INVISIBLE);
                        }
                        else if(d != null)
                            d.setColor(Color.GREEN);
                        else
                            c.setColor(Color.GREEN);

                        dialog.dismiss();
                    }
                });

                naranja.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            color1.setBackgroundColor(ORANGE);
                            naranja.setVisibility(View.INVISIBLE);
                        }
                        else if(color2 != null){
                            color2.setBackgroundColor(ORANGE);
                            naranja.setVisibility(View.INVISIBLE);
                        }
                        else if(d != null)
                            d.setColor(ORANGE);
                        else
                            c.setColor(ORANGE);

                        dialog.dismiss();
                    }
                });

                rosa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){
                        // Añadimos el cambio del color al boton
                        if(color1 != null){
                            color1.setBackgroundColor(PINK);
                            rosa.setVisibility(View.INVISIBLE);
                        }
                        else if(color2 != null){
                            color2.setBackgroundColor(PINK);
                            rosa.setVisibility(View.INVISIBLE);
                        }
                        else if(d != null)
                            d.setColor(PINK);
                        else
                            c.setColor(PINK);

                        dialog.dismiss();
                    }
                });

                negro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view){

                        if(d != null)
                            d.setColor(Color.BLACK);
                        else
                            c.setColor(Color.BLACK);

                        dialog.dismiss();
                    }
                });

            }

        });

        return dialog;
    }

    public void setD(Dibujar d, Colorear c) {
        this.d = d;
        this.c = c;
    }

    public void insertarColorResultado(int resultado){
        pm.findViewById(R.id.resultado).setBackgroundColor(resultado);
    }

    public void colorResultado(){
        int resultadoColor;

        resultadoColor = PINK + ORANGE;
        insertarColorResultado(resultadoColor);
    }
}