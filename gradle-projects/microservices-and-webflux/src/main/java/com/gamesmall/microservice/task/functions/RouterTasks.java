package com.gamesmall.microservice.task.functions;

import com.gamesmall.microservice.task.handlers.HandlerTasks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterTasks {

    @Bean
    public RouterFunction<ServerResponse> routes(HandlerTasks handlerTasks) {
        return RouterFunctions.route(GET("/api/tasks"), handlerTasks::getAllTask)
                .andRoute(POST("api/tasks"), handlerTasks::createNewTask);
    }

}
