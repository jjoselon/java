package com.company.webflux.routing;

import com.company.webflux.endpoints.Heroes;
import com.company.webflux.models.Heroe;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_PLAIN;

import java.io.FileNotFoundException;

/**
 * /api/endpoint[X]?file=RequestPOSTNotFound.php
 * /api/endpoint[X]?file=RequestPOST.php
 * /api/endpoint[X]?file=RequestPOST_error403.php
 * /api/endpoint[X]?file=RequestPOST_error500.php
 * @see <a href="https://github.com/eugenp/tutorials/tree/master/spring-reactive-modules/spring-reactive/src/main/java/com/baeldung/reactive">Error Handling</a>
 * @see <a href="https://www.appsdeveloperblog.com/exception-handling-in-project-reactor/">Handling Exceptions in Project Reactor</a>
 * @see <a href="https://www.appsdeveloperblog.com/doon-callbacks-in-project-reactor/">doOn Callbacks in Project Reactor</a>
 */
@Component
public class Handler {

    private static final String EXCEPTION_OCCURRED = "Exception occurred";
    public Mono<ServerResponse> handleRequestOnErrorMap(ServerRequest request) {
        String file = request.queryParam("file").get();
        return Heroes
            .createRequest(file)
            .onErrorMap(e -> new RuntimeException(EXCEPTION_OCCURRED))
            // onErrorMap retorna la excepción. Si no encuentra a onErrorResume o onErrorReturn
            // delegara el request a GlobalErrorWebExceptionHandler quien se encargara de responder
//            .onErrorReturn(new Heroe())
            .flatMap(s -> ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(s));
    }

    public Mono<ServerResponse> handleRequestOnErrorReturn(ServerRequest request) {

        /* Hardcoded Test */
        Mono.just(new Heroe("Hulk"))
            .concatWith(Mono.error(new RuntimeException(EXCEPTION_OCCURRED)))
            .concatWith(Mono.just(new Heroe("Superman")))
            .onErrorReturn(error -> true, new Heroe("Acuaman"))
            .concatWith(Mono.just(new Heroe("Batman"))) // El resto del stream continua normal
            .log()
            .subscribe();
        /* Hardcoded Test */

        String file = request.queryParam("file").get();
        return Heroes
            .createRequest(file)
            .onErrorReturn(error -> true, new Heroe())
            .flatMap(s -> ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(s));
    }

    /**
     * Según las firmas de los (3) métodos. Todos deben retornar un Mono de T
     */
    public Mono<ServerResponse> handleRequestOnErrorResume(ServerRequest request) {

        /* Hardcoded Test */
        Mono.just(new Heroe("Hulk"))
            .concatWith(Mono.error(new RuntimeException(EXCEPTION_OCCURRED)))
            .concatWith(Mono.just(new Heroe("Superman")))
            .onErrorResume(error -> Mono.just(new Heroe("Acuaman")))
            .concatWith(Mono.just(new Heroe("Batman")))
            .log()
            .subscribe();
        /* Hardcoded Test */

        String file = request.queryParam("file").get();
        return Heroes.createRequest(file)
            .onErrorResume(FileNotFoundException.class, e ->  {
                System.out.println(e.getMessage());
                return Mono.just(new Heroe("Spider man"));
            })
            .onErrorResume(HttpServerErrorException.InternalServerError.class, e ->  {
                System.out.println(e.getMessage());
                return Mono.just(new Heroe("Linterna verde"));
            })
            .onErrorResume(HttpClientErrorException.Forbidden.class, e ->  {
                System.out.println(e.getMessage());
                return Mono.just(new Heroe("Pantera negra"));
            })
            .onErrorResume(e -> {
                System.out.println("Error que hace match con todos");
                System.out.println(e.getMessage());
                return Mono.just(new Heroe("Iron Man"));
            })
            .flatMap(s -> ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(s));
    }

    /**
     * El método onErrorReturn en este caso es propagado cuando recibe un Mono.error
     *
     * @return Mono
     */
    public Mono<ServerResponse> handleWithErrorReturn(ServerRequest request) {
        return sayHello(request)
            .onErrorReturn("Hello, Stranger")
            .flatMap(s -> ServerResponse.ok()
                .contentType(TEXT_PLAIN)
                .bodyValue(s));
    }

    /**
     * Global error web excepción handler
     */
    public Mono<ServerResponse> handleWithGlobalErrorHandler(ServerRequest request) {
        return ServerResponse.ok()
            .body(sayHello(request), String.class);
    }

    public Mono<ServerResponse> handleWithErrorResumeAndDynamicFallback(ServerRequest request) {
        return sayHello(request)
            .flatMap(s -> ServerResponse.ok()
                .contentType(TEXT_PLAIN)
                .bodyValue(s))
            .onErrorResume(e -> (Mono.just("Hi, I looked around for your name but found: " + e.getMessage()))
                .flatMap(s -> ServerResponse.ok()
                    .contentType(TEXT_PLAIN)
                    .bodyValue(s)));
    }

    private Mono<String> sayHelloFallback() {
        return Mono.just("Hello, Stranger");
    }

    private Mono<String> sayHello(ServerRequest request) {
        try {
            return Mono.just("Hello, " + request.queryParam("name").get());
        } catch (Exception e) {
            return Mono.error(e);
        }
    }


}
