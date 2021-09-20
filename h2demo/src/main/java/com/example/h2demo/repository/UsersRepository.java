package com.example.h2demo.repository;

import com.example.h2demo.entity.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UsersRepository extends R2dbcRepository<Users,Integer> {
}
