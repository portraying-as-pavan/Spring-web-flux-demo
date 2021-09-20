package com.example.Task1;


import com.example.Task1.entity.User;
import com.example.Task1.repository.UserRepository;
import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@SpringBootApplication

public class Task1Application {

	public static void main(String[] args) {
		SpringApplication.run(Task1Application.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository, DatabaseClient client) {
		return args -> {
			client.execute("create table IF NOT EXISTS USER" +
					("id INT PRIMARY KEY , username VARCHAR(200);")).fetch().first().subscribe();
			client.execute("delete from USER;").fetch().first().subscribe();

			Stream<User> stream = Stream.of(new User(1, "User1"),
					new User(2, "User2"),
					new User(3, "User3"));

			userRepository.saveAll(Flux.fromStream(stream))
					.then()
					.subscribe();
		};


	}


}



