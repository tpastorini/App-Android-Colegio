package com.example.tati.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdaptadorColores extends BaseAdapter {
    private Context my_context;

    public AdaptadorColores(Context context){
        my_context = context;
    }

    @Override
    public int getCount() {
        return ColoresGrid.colores.length;
    }

    @Override
    public ColoresGrid getItem(int position) {
        return ColoresGrid.colores[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) my_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.grid_item_colores, parent, false);
        }

        ImageView img_color = (ImageView) view.findViewById(R.id.img_color);
        TextView nombre_color = (TextView) view.findViewById(R.id.nombre_color);

        final ColoresGrid color = getItem(position);

        Glide.with((img_color.getContext())).load(color.getIdDrawable()).into(img_color);

        nombre_color.setText(color.getNombre());

        return view;
    }
}
