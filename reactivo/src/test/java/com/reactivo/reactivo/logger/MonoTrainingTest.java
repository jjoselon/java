package com.reactivo.reactivo.logger;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MonoTrainingTest {

    @Test
    void filter() {
        StepVerifier
                .create(MonoTraining.filter())
                .expectNext("Jose").verifyComplete();
    }
}
