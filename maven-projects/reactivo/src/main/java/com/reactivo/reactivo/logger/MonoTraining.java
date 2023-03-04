package com.reactivo.reactivo.logger;

import reactor.core.publisher.Mono;

public class MonoTraining {

    public static Mono<String> filter() {
        return Mono.just("José");
    }
}
