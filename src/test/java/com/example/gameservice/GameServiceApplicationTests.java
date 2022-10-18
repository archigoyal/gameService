package com.example.gameservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.gameservice.GameServiceApplication.printResults;

@Slf4j
@SpringBootTest
class GameServiceApplicationTests {
    StoreRecord str;
	@Test
	void contextLoads() {

		printResults();
	}

}
