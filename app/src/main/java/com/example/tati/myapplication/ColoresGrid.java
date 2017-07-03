package com.example.tati.myapplication;

public class ColoresGrid {
    private String nombre;
    private int idDrawable;

    public ColoresGrid() {}

    // Constructor por parámetros
    public ColoresGrid(String nombre, int idDrawable){
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre(){
        return nombre;
    }

    public int getIdDrawable(){
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static ColoresGrid[] colores = {
            new ColoresGrid("Violeta", R.drawable.violeta),
            new ColoresGrid("Verde", R.drawable.verde),
            new ColoresGrid("Naranja", R.drawable.naranja),
            new ColoresGrid("Rosa", R.drawable.rosa),
            new ColoresGrid("Blanco", R.drawable.blanco),
            new ColoresGrid("Negro", R.drawable.negro),
            new ColoresGrid("Gris", R.drawable.gris)
    };

    // Obtiene el item según su ID
    public static ColoresGrid getColor_ID(int id){
        for(ColoresGrid item : colores){
            if(item.getId() == id){
                return item;
            }
        }

        return null;
    }
}
