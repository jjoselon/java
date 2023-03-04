package com.reactivo.reactivo;

import com.reactivo.reactivo.models.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReactivoApplication implements CommandLineRunner {

	private List<Persona> lista() {
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona(1, "Perro"));
		lista.add(new Persona(2, "Gato"));
		lista.add(new Persona(3, "Conejo"));
		return lista;
	}
	public void mono() {

	}

	public void flux() {
		Flux.fromIterable(lista())
				.filter(persona -> persona.getIdentificador() == 1)
//				.map(persona -> {
//					persona.setNombres(persona.getNombres() + " Blanco");
//					return persona;
//				})
				.subscribe(p -> Log.info(p.toString()));
	}

	public void reactor() {
		Mono.just(new Persona(1, "Alejandro Rivera")).log()
				.doOnNext(p -> {
					Log.info("Realizamos una operación con el dato..." + p);
				})
				.subscribe();
	}

	private static final Logger Log = LoggerFactory.getLogger(ReactivoApplication.class);

	public static void main(String[] args) {
		Hooks.onOperatorDebug();
		SpringApplication.run(ReactivoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		flux();
	}
}
