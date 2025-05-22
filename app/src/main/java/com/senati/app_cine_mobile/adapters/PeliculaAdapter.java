package com.senati.app_cine_mobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.senati.app_cine_mobile.R;
import com.senati.app_cine_mobile.entities.Pelicula;

import java.util.List;

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    private Context context;
    private List<Pelicula> listPeliculas;
    public PeliculaAdapter(@NonNull Context context, List<Pelicula> listPeliculas) {
        super(context, R.layout.list_item_pelicula, listPeliculas);
        this.context = context;
        this.listPeliculas = listPeliculas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_pelicula, parent, false);
        }
        Pelicula pelicula = listPeliculas.get(position);
        TextView tvItemTitulo = convertView.findViewById(R.id.tvItemTitulo);
        TextView tvItemClasificacion = convertView.findViewById(R.id.tvItemClasificacion);
        TextView tvItemDuracionMin = convertView.findViewById(R.id.tvItemDuracionMin);

        tvItemTitulo.setText(pelicula.getTitulo());
        tvItemClasificacion.setText(pelicula.getClasificacion());
        tvItemDuracionMin.setText(String.valueOf(pelicula.getDuracionMin()));
        return  convertView;
    }


}
