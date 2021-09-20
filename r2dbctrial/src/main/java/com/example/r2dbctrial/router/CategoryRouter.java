package com.example.r2dbctrial.router;

import com.example.r2dbctrial.entity.Category;
import com.example.r2dbctrial.handler.CategoryHandler;
import com.example.r2dbctrial.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.RouteMatcher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class CategoryRouter {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryHandler handler;

    @Bean
    public RouterFunction<ServerResponse> getAllCategories(){
     /*   return route(GET("/categories"),
                req->ok().body(
                        categoryRepository.findAll(), Category.class
                ));

      */
        return RouterFunctions.route()
                .GET("/categories",handler::getAllCategories)
                .GET("/category/{id}",handler::getCategoryById)
                .build();

    }


}
