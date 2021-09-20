package com.example.r2dbctrial.repository;

import com.example.r2dbctrial.entity.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<Category,Integer> {
}
