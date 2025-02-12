package com.company.webflux.services;


import com.company.webflux.models.Heroe;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bean2 {

    @Bean
    public Heroe getDefaultHeroe() {
        return new Heroe("Stranger thing");
    }
}
