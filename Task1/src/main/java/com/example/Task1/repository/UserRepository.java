package com.example.Task1.repository;

import com.example.Task1.entity.User;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
