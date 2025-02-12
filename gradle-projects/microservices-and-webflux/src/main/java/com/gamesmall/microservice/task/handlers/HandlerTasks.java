package com.gamesmall.microservice.task.handlers;

import com.gamesmall.microservice.task.entities.Task;
import com.gamesmall.microservice.task.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HandlerTasks {

    @Autowired
    private ITaskRepository taskRepository;

    public Mono<ServerResponse> getAllTask(ServerRequest serverRequest) {
        Task task = new Task("Hacer la comida", "no se hace", false);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(task), Task.class);
    }

    public Mono<ServerResponse> createNewTask(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Task.class) // Convertir el JSON del body a un objeto Task
                .map(taskRepository::save) // Se guarda en la DB, el map sigue manteniendo Task
                .flatMap(taskSaved -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(taskSaved));

    }
}
