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

import org.json.JSONArray;

public class ListarActivity extends AppCompatActivity {

    // Constante Endpoint
    private final String URL = "https://apirestpeliculassenati-production.up.railway.app/api/v1/movies";


    //Llamado a API
    RequestQueue requestQueue;
    ListView listaPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        loadUI();
        getAll();
    }

    private void loadUI(){
        listaPeliculas = findViewById(R.id.listaPeliculas);
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
}