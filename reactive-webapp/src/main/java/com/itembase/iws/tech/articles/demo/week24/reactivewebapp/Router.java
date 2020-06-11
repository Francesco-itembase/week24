package com.itembase.iws.tech.articles.demo.week24.reactivewebapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Router
{
    @Bean
    public RouterFunction<ServerResponse> route(Handler handler)
    {
        return RouterFunctions
                .route(RequestPredicates.GET("/endpoint").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::response)
                .andRoute(RequestPredicates.GET("/slow").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::slowResponse);
    }
}
