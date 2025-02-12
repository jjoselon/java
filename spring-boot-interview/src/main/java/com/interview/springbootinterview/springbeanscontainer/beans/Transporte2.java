package com.interview.springbootinterview.springbeanscontainer.beans;

import com.interview.springbootinterview.springbeanscontainer.model.Bicicleta;
import org.springframework.stereotype.Component;

@Component
public class Transporte2 implements IVehiculo {

    private final String marca;
    private final String color;

    public Transporte2(Bicicleta bicicleta) {
        this.marca = bicicleta.getMarca();
        this.color = bicicleta.getColor();
    }

    @Override
    public String getMarca() {
        return this.marca.toUpperCase();
    }

    @Override
    public String getColor() {
        return this.color.toUpperCase();
    }
}
