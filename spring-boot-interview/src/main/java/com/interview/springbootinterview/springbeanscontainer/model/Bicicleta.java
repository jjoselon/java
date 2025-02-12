package com.interview.springbootinterview.springbeanscontainer.model;

public class Bicicleta {
    private final String color;
    private final String marca;
    public Bicicleta(String color, String marca) {
        this.color = color;
        this.marca = marca;
    }
    public String getColor() {
        return color;
    }
    public String getMarca() {
        return marca;
    }
}
