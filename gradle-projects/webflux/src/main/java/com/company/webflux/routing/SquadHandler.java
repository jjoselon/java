package com.company.webflux.routing;

import com.company.webflux.endpoints.Heroes;
import com.company.webflux.models.Squad;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class SquadHandler {
    public Mono<ServerResponse> handleRequestGetSquad(ServerRequest request) {
        return Heroes.getSquad()
            .flatMap(squad -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(squad));
    }
}