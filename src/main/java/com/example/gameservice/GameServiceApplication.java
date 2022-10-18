package com.example.gameservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class GameServiceApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(GameServiceApplication.class, args);
	}


}
