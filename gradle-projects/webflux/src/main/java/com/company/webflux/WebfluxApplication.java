package com.company.webflux;

import com.company.webflux.endpoints.Heroes;
import com.company.webflux.models.Heroe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.util.Arrays;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		System.out.println("JDK version " + System.getProperty("java.version"));
		SpringApplication.run(WebfluxApplication.class, args);
//		mono_squad();
		//mapAndFilterOperatorTest();
		//flatMapOperatorTest();
		//mergeAndConcatOperatorTest();
		zipOperatorTest();
	}

	public static void zipOperatorTest() {
		Flux<String> flux1 = Flux.just("José", "Alejandro");
		Flux<String> flux2 = Flux.just("Ramirez", "Rivera");

		Flux.zip(flux1, flux2, (f1, f2) -> f1.concat(" ").concat(f2)).log().subscribe();
	}

	public static void mergeAndConcatOperatorTest() {
		Mono<String> mono1 = Mono.just("José");
		Mono<String> mono2 = Mono.just("Ramirez");

		//Mono.from(mono1).mergeWith(mono2).log().subscribe();
		//Flux.merge(mono1, mono2).log().subscribe();
		Flux.concat(mono1, mono2).log().subscribe();
	}

	public static void mapAndFilterOperatorTest() {
		String[] nombres = new String[]{"Jose", "Jane", "Mary", "Bob"};
		// List<String> heroes = List.of("Jos", "Ram");

		Flux.fromArray(nombres).map(String::toUpperCase)
				.filter(s -> s.length() > 3)
				.log()
				.subscribe();

		System.out.println(Arrays.toString(nombres)); // no se muta los datos originales
	}

	public static void flatMapOperatorTest() {
		String[] nombres = new String[]{"Jose", "Jane", "Mary", "Bob"};
		// List<String> heroes = List.of("Jos", "Ram");

		Flux.fromArray(nombres).flatMap(s ->
						//Flux.just(new Heroe(s), new Heroe(s), new Heroe(s), new Heroe(s))
						Mono.just(new Heroe(s))
				)
				.map(Heroe::getName)
				.log()
				.subscribe();

		System.out.println(Arrays.toString(nombres)); // no se muta los datos originales

	}

	public static void mono_squad() {
		Heroes
			.getSquad()
			.map(squad -> {
				System.out.println(squad.getFormed());
				System.out.println(squad.getMembers().get(0).getName());
				return squad;
			}).subscribe();
	}

	public static void dada() {
		WebClient client = WebClient.create();
		// Funciona el debugger si ubicó en la lambda clientResponse  -> ...
//		Mono<String> mono = client.get().uri("http://localhost/php/GET-request-with-AJAX/RequestGET.php")
// 				.headers(httpHeaders -> httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
//				.accept(MediaType.APPLICATION_JSON)
//				.exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class));
//		mono.doOnNext(s -> System.out.println("hola" + s)).subscribe();

		// De alguna forma debo subscribirme al stream de datos con subscribe() para que tenga efecto el breakpoint
		// de clientResponse -> ... en este caso
//		client.get().uri("http://localhost/php/GET-request-with-AJAX/RequestGET.php")
// 				.headers(httpHeaders -> httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
//				.accept(MediaType.APPLICATION_JSON)
//				.exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class)).subscribe();		// De alguna forma debo subscribirme al stream de datos con subscribe() para que tenga efecto el breakpoint

//		// de clientResponse -> ... en este caso aun responde siendo 404
//		client.get().uri("http://localhost/php/GET-request-with-AJAX/RequestGE.php")
// 				.headers(httpHeaders -> httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
//				.accept(MediaType.APPLICATION_JSON)
//				.exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class)).subscribe();		// de clientResponse -> ... en este caso aun responde siendo 404

		client.get().uri("http://localhost/php/GET-request-with-AJAX/RequestGET_error500.php")
 				.headers(httpHeaders -> httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
				.accept(MediaType.APPLICATION_JSON)
				.exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class))
				.doOnNext(s -> System.out.println(s))
				.subscribe();

	}

	public static void mono_post1() {

//		Mono<Heroe> mono = Heroes.createRequest().bodyToMono(Heroe.class); // Convertimos el body del response a un Mono!!!
//
//		mono
//			.doOnNext(heroe -> System.out.println(heroe.getName()))
//			.doOnSuccess(heroe -> System.out.println("Exitoso"))
////			.log()
//			.subscribe();
	}

	public static void mono_get1() {

		Mono<Heroe> mono = Heroes.getAllRequest().bodyToMono(Heroe.class); // Convertimos el body del response a un Mono!!!

		System.out.println(mono.block());

		mono.doOnNext(heroe -> System.out.println(heroe.getName())).log().subscribe();
	}

	public static void client1_MonoHeroeErrorHandling_with_onStatus() {
		WebClient client = WebClient.create();

		/* PRIMERA FORMA */
		WebClient.ResponseSpec responseSpec = client.get()
				.uri("http://localhost/GET-request-with-AJAX/RequestGE.php") // File will not be found (a proposito)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve();

		Mono<Heroe> entityMono1 = responseSpec
				.onStatus(
						httpStatus -> httpStatus.is4xxClientError(), // Predicate: Represents a predicate (boolean-valued function) of one argument.
						clientResponse -> Mono.error(new FileNotFoundException("El recurso solicitado no existe")) // Function: Represents a function that accepts one argument and produces a result.
				)
				.bodyToMono(Heroe.class);

		entityMono1.doOnNext(heroe -> System.out.println(heroe.getName())).log().subscribe();
	}

	public static void client1_MonoHeroe() {

		WebClient client = WebClient.create();

		/* PRIMERA FORMA */
		WebClient.ResponseSpec responseSpec = client.get()
				.uri("http://localhost/GET-request-with-AJAX/RequestGET.php")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve();

		Mono<Heroe> entityMono1 = responseSpec.bodyToMono(Heroe.class);

		entityMono1.doOnNext(heroe -> System.out.println(heroe.getName())).log().subscribe();

		/* SEGUNDA FORMA */

//		Mono<Heroe> entityMono2 = client.get()
//				.uri("http://localhost/GET-request-with-AJAX/RequestGET.php")
//				.accept(MediaType.APPLICATION_JSON)
//				.exchangeToMono(clientResponse -> {
//					if (clientResponse.statusCode().equals(HttpStatus.OK)) {
//						return clientResponse.bodyToMono(Heroe.class);
//					} else {
//						System.out.println("Error: ");
//						return clientResponse.createException().flatMap(Mono::error);
//					}
//				});
//
//		System.out.println("WebfluxApplication.client1");
//		entityMono2.doOnNext(heroe -> System.out.println(heroe.getName())).log().subscribe();

	}

	public static void client1_FluxHeroe() {
		WebClient client = WebClient.create();

		Flux<Heroe> entityMono = client.get()
				.uri("http://localhost/php/GET-request-with-AJAX/RequestGET2.php")
				.accept(MediaType.APPLICATION_JSON)
				.exchangeToFlux(clientResponse -> {
					if (clientResponse.statusCode().equals(HttpStatus.OK)) {
						return clientResponse.bodyToFlux(Heroe.class);
					} else {
						System.out.println("Error: ");
						return clientResponse.createException().flatMapMany(Mono::error);
					}
				});

		System.out.println("WebfluxApplication.client1_FluxHeroe");
		entityMono
			.doOnNext(heroe -> System.out.println(heroe.getName()))
			.log()
			.subscribe();

	}

}
