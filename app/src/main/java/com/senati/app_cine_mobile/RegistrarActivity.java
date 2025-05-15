package com.senati.app_cine_mobile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class RegistrarActivity extends AppCompatActivity {

    private final String URL = "https://apirestpeliculassenati-production.up.railway.app/api/v1/movies/create";
    private final String EndpointEliminar = "https://apirestpeliculassenati-production.up.railway.app/api/v1/movies/delete/6";
    RequestQueue requestQueue;
    Button btnRegistrarPelicula;
    Button btnEliminarPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        loadUI();
    }

    private void loadUI(){
        btnRegistrarPelicula = findViewById(R.id.btnRegistrarPelicula);
        btnEliminarPelicula = findViewById(R.id.btnEliminar);
    }

    public void RegistrarPelicula(View view){
        requestQueue = Volley.newRequestQueue(this);

        JSONObject data = new JSONObject();
        try{
            data.put("titulo", "Karate Kid"); //el segundo param es el campo de formulario (por ahora no hay)
            data.put("duracionMin",130);
            data.put("clasificacion","+14");
            data.put("lanzamiento","2013");
        }catch (Exception e){
            Log.e("Error JSON", e.toString());
        }

        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("condicion", response.toString());
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("Error webServices", error.toString());
                    }
                }
        );
        requestQueue.add(jsonRequest);
    }

    public void eliminar(View view){
        requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.DELETE,
                EndpointEliminar,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("pelicula elimina", response.toString());
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("Error webServices", error.toString());
                    }
                }
        );
        requestQueue.add(jsonRequest);
    }
}