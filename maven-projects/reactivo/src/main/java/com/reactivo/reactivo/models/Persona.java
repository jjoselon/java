package com.reactivo.reactivo.models;

public class Persona {
    private int identificador;
    private String nombres;

    public Persona(int identificador, String nombres) {
        this.identificador = identificador;
        this.nombres = nombres;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "identificador=" + identificador +
                ", nombres=" + nombres +
                '}';
    }
}
