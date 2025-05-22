package com.senati.app_cine_mobile.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private void showModal(String message, int id){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle("Confirmacion del proceso");
        dialog.setMessage(message);
        dialog.setCancelable(false);
        dialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,"Proceso del id: "+String.valueOf(id),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("cancelar",null);
        dialog.create().show();
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
        Button btnItemVermas = convertView.findViewById(R.id.btnDescripcion);

        btnItemVermas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showModal("Proceso", pelicula.getId());
            }
        });

        tvItemTitulo.setText(pelicula.getTitulo());
        tvItemClasificacion.setText(pelicula.getClasificacion());
        tvItemDuracionMin.setText(String.valueOf(pelicula.getDuracionMin()));
        return  convertView;
    }


}
