package com.senati.app_cine_mobile;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.senati.app_cine_mobile.adapters.PeliculaAdapter;
import com.senati.app_cine_mobile.entities.Pelicula;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    // Constante Endpoint
    private final String URL = "https://apirestpeliculassenati-production.up.railway.app/api/v1/movies";


    //Llamado a API
    RequestQueue requestQueue;
    ListView lisViewPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        loadUI();
        getAll();
    }

    private void loadUI(){
        lisViewPeliculas = findViewById(R.id.listaPeliculas);
    }

    private void getAll(){
        //paso1: Canal de comunicacion
        requestQueue = Volley.newRequestQueue(this);
        //paso2: Preparacion de la solicitud
        JsonArrayRequest jsonRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       procesarDatos(response);
                       Log.d("Peliculas", response.toString());
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("Error webServices", error.toString());
                    }
                }
        );
        //paso3: Envio de la solicitud por el canal de comunicacion
        requestQueue.add(jsonRequest);
    }

    /*
    * Renderizar los datos de la api en el ListView utilizando adaptador personalizado
    * */
    private void procesarDatos(JSONArray response){
        try {
            Pelicula pelicula;
            ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

            for (int i=0 ; i< response.length(); i++){
                JSONObject jsonObject = response.getJSONObject(i);
                pelicula = new Pelicula();
                pelicula.setId(jsonObject.getInt("ID"));
                pelicula.setTitulo(jsonObject.getString("TITULO"));
                pelicula.setDuracionMin(jsonObject.getInt("DURACION_MIN"));
                pelicula.setClasificacion(jsonObject.getString("CLASIFICACION"));
                pelicula.setLanzamiento(jsonObject.getString("LANZAMIENTO"));

                listaPeliculas.add(pelicula);
            }

            PeliculaAdapter adapter = new PeliculaAdapter(this,listaPeliculas);
            lisViewPeliculas.setAdapter(adapter);
        }catch (Exception e){
            Log.e("Error JSONArray", e.toString());
        }
    }
}