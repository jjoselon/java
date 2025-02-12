package com.interview.springbootinterview.springbeanscontainer.beans;

import com.interview.springbootinterview.springbeanscontainer.model.Bicicleta;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Transporte implements IVehiculo {
    private String marca;
    private String color;

    public Transporte(Bicicleta bicicleta) {
        this.marca = bicicleta.getMarca();
        this.color = bicicleta.getColor();
    }

    public String getMarca() {
        return marca;
    }
    public String getColor() {
        return color;
    }
}
