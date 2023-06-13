package com.gamesmall.jpa.intro.jpaintro.bootstrap;

import com.gamesmall.jpa.intro.jpaintro.domain.Libro;
import com.gamesmall.jpa.intro.jpaintro.repositories.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final LibroRepository libroRepository;

    public DataInitializer(LibroRepository libroRepository) {
        // Dependency injection in action ?
        this.libroRepository = libroRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Libro libroA = new Libro("Psicología del éxito", "123", "Mario Luna");
        this.libroRepository.save(libroA);
        System.out.println("Id " + libroA.getId());
    }
}
