package com.senati.app_cine_mobile.entities;

public class Pelicula {
    private int id;
    private String titulo;
    private int duracionMin;
    private String clasificacion;
    private String lanzamiento;

    public Pelicula(){};

    public Pelicula(int id, String titulo, int duracionMin, String clasificacion, String lanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.clasificacion = clasificacion;
        this.lanzamiento = lanzamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
}
