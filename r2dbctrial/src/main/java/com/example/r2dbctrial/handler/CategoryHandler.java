package com.example.r2dbctrial.handler;

import com.example.r2dbctrial.entity.Category;
import com.example.r2dbctrial.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoryHandler {

    @Autowired
    private CategoryRepository categoryRepository;

    public Mono<ServerResponse> getAllCategories(ServerRequest request){
        Flux<Category> categoryFlux=categoryRepository.findAll();
        return ServerResponse.ok().body(categoryFlux,Category.class);
    }

    public Mono<ServerResponse> getCategoryById(ServerRequest request){
        int id=Integer.parseInt(request.pathVariable("id"));
        Mono<Category> category = categoryRepository.findById(id);
        return ServerResponse.ok().body(category,Category.class);
    }
    public Mono<ServerResponse> saveCategory(ServerRequest request){
        Mono<Category> categoryMono = request.bodyToMono(Category.class);
        Mono<String> map = categoryMono.map(dto -> dto.getId() + " " + dto.getName());
        return ServerResponse.ok().body(map,String.class);
    }

}
