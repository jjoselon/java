package com.gamesmall.entities;

public class Respuesta {

    private int id;
    private Pregunta pregunta;
    private boolean isCorrecta = false;
    private String descripcion;
    private int orden;

    public int getOrden() {
        return orden;
    }

    public Respuesta setNextOrden(int orden) {
        this.orden = orden;
        return this;
    }

    public int getId() {
        return id;
    }

    public Respuesta setId(int id) {
        this.id = id;
        return this;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public Respuesta setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
        return this;
    }
    
    public boolean getIsCorrecta() {
        return this.isCorrecta;
    }
    public void isCorrecta() {
        this.isCorrecta = true;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Respuesta setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
