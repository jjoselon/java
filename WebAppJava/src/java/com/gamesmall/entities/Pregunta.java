package com.gamesmall.entities;

import java.io.Serializable;
import java.util.ArrayList;
// import java.util.List; // lo usaba con hibernate

public class Pregunta implements
        Serializable {
    private int id;
    private String enunciado;
    private float valor;
    private ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

    public ArrayList getRespuestas()
    {
        return this.respuestas;
    }

    public void setRespuestas(ArrayList respuestas)
    {
        this.respuestas = respuestas;
    }

    public void addRespuesta(Respuesta respuesta)
    {
        this.respuestas.add(respuesta);
    }

    public Pregunta(String enunciado, float valor) {
        this.enunciado = enunciado;
        this.valor = valor;
    }
    
    public Pregunta() {

    }

    public int getId() {
        return id;
    }

    public Pregunta setId(int id) {
        this.id = id;
        return this;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public Pregunta setEnunciado(String enunciado) {
        this.enunciado = enunciado;
        return this;
    }

    public float getValor() {
        return valor;
    }

    public Pregunta setValor(float valor) {
        this.valor = valor;
        return this;
    }
    
    
    
}


