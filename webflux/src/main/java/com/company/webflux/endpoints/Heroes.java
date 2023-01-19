package com.company.webflux.endpoints;

import com.company.webflux.models.Heroe;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;

public abstract class Heroes {

    private static final WebClient client = WebClient.create();

    public static Mono<Heroe> createRequest(String file) {
        return client.post()
            .uri("http://localhost/php/POST-request-with-AJAX/" + file)
            .contentType(MediaType.APPLICATION_JSON) // post tiene contentType debido a que es una petición con un body.
            .bodyValue("Este es el body de la petición de forma muy basic")
            .retrieve()
            .onStatus(
                httpStatus -> httpStatus.is4xxClientError(), // Predicate: Represents a predicate (boolean-valued function) of one argument.
                clientResponse -> Mono.error(new HttpClientErrorException(clientResponse.statusCode(), "Un error 4xx")) // Function: Represents a function that accepts one argument and produces a result.
            )
            .onStatus(
                httpStatus -> httpStatus.is5xxServerError(),
                clientResponse -> Mono.error(new HttpServerErrorException(clientResponse.statusCode(), "Un error 5xx"))
            )
            .bodyToMono(Heroe.class);
    }

    public static WebClient.ResponseSpec getAllRequest() {
        return client.get()
            .uri("http://localhost/php/GET-request-with-AJAX/RequestGET.php")
            .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML)
            .acceptCharset(StandardCharsets.UTF_8)
            .cookie("Cookie-name", "Cookie-value")
            .cookies(
                // Consumer: Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
                stringStringMultiValueMap -> {
                    stringStringMultiValueMap.add("Another-cookie-name", "Another-cookie-value");
                    System.out.println(stringStringMultiValueMap.get("Another-cookie-name"));
                    System.out.println(stringStringMultiValueMap.getFirst("Cookie-name"));
                }
            )
            .httpRequest(
                // Consumer
                clientHttpRequest -> {
                    System.out.println("[URI]" + clientHttpRequest.getURI());
                    System.out.println("[HEADERS]" + clientHttpRequest.getHeaders());
                    System.out.println("[METHOD]" + clientHttpRequest.getMethod());
                }
            )
            .header("Custom-header-name", "Custom-header-value")
            .retrieve();
    }
}
