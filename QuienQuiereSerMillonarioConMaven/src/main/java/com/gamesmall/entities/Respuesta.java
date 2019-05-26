package com.gamesmall.entities;

public class Respuesta {

    private int id;
    private Pregunta pregunta;
    private boolean isCorrecta = false;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
