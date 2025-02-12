package com.interview.springbootinterview.springbeanscontainer.beans;

import com.interview.springbootinterview.springbeanscontainer.model.Bicicleta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Vehiculo {

    @Bean
    public Bicicleta bicicleta() {
        return new Bicicleta("Verde manzana", "Pajarito");
    }
}
