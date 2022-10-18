package com.example.gameservice;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.example.gameservice.GameServiceApplication.printResults;
import static com.example.gameservice.Stream.readStream;

@Slf4j
@SpringBootTest
public class StreamTests {

    @Test
    void contextLoads() throws IOException {

        readStream("src/test/resources/sample3.txt");
        printResults();
    }

}
