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
public class Router {

    @Bean
    public RouterFunction<ServerResponse> routes(Handler handler) {
        return RouterFunctions
            .route(GET("/api/endpoint1").and(accept(TEXT_PLAIN)), handler::handleWithErrorReturn)
            .andRoute(GET("/api/endpoint3").and(accept(TEXT_PLAIN)), handler::handleWithErrorResumeAndDynamicFallback)
            .andRoute(GET("/api/endpoint5").and(accept(TEXT_PLAIN)), handler::handleWithGlobalErrorHandler)
            .andRoute(GET("/api/endpoint6").and(accept(TEXT_PLAIN)), handler::handleRequestOnErrorReturn)
            .andRoute(GET("/api/endpoint7").and(accept(TEXT_PLAIN)), handler::handleRequestOnErrorResume)
            .andRoute(GET("/api/endpoint8").and(accept(TEXT_PLAIN)), handler::handleRequestOnErrorMap);
    }
}
