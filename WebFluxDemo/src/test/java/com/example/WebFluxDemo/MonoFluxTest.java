package com.example.WebFluxDemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void MonoTest(){
        Mono mono=Mono.just("New Mono")
              //  .then(Mono.error(new RuntimeException("Exception in mono")))
                .log();
        mono.subscribe(System.out::println,(e)-> System.out.println(e));
    }

    @Test
    public void FluxTest(){
        Flux<String> flux = Flux.just("Flux 1", "Flux 2", "Flux 3")
                .concatWithValues("Flux 4")
             //   .concatWith(Flux.error(new RuntimeException("Error in Flux")))
                .concatWithValues("Flux 5")
                .log();
        flux.subscribe(System.out::println,(e)-> System.out.println(e));
    }
}
