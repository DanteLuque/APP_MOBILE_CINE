package com.senati.app_cine_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadUI();
    }

    public void btnListar(View view){
        startActivity(new Intent(MainActivity.this, ListarActivity.class));
    }

    public void btnRegistrar(View view){
        startActivity(new Intent(MainActivity.this, RegistrarActivity.class));
    }

    private void loadUI(){

    }
}