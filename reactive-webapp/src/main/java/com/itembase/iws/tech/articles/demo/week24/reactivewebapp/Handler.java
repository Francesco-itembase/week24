package com.itembase.iws.tech.articles.demo.week24.reactivewebapp;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class Handler
{
    public Mono<ServerResponse> response(ServerRequest serverRequest)
    {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Text Response"));
    }

    public Mono<ServerResponse> slowResponse(ServerRequest serverRequest)
    {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Text Response"))
                .delayElement(Duration.ofMillis(100));
    }
}
