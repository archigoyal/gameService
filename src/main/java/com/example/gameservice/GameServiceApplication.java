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
		GamingService();
		printResults();
	}

	public static void GamingService() throws IOException {
		System.out.println("Hello gamers!");
		Stream.readStream("src/main/resources/sample1.txt");
        Stream.readStream("src/main/resources/sample2.txt");

	}
	public static void printResults(){
		System.out.println("-----RESULTS-----------------");
		System.out.println("ID"+ "\t" +"Score"+"\t" +"Name");

		for(Participant p : StoreRecord.getTopper())
			System.out.println(p.getId()+ "\t" +p.getScore()+"\t" +p.getName());
	}


}
