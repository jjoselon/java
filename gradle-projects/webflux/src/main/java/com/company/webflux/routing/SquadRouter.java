package com.company.webflux.routing;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
public class SquadRouter {
    @Bean
    public RouterFunction<ServerResponse> squadRoutes(SquadHandler handler) {
        return RouterFunctions
            .route(GET("/api/squad").and(accept(TEXT_PLAIN)), handler::handleRequestGetSquad);
    }
}
