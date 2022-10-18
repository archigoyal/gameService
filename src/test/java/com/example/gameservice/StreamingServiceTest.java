package com.example.gameservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class StreamingServiceTest {

    @Mock
    RecordStoringService rss;
    @Mock
    MongoService ms;

    @InjectMocks
    StreamingService ss;

    @Test
    void readStreamTestException() throws IOException {
        ss.readStream("src/test/resources/sample2.txt");

        assertThrows(IOException.class, () -> ss.readStream("src/test/resources.txt") );
    }
    @Test
    void readStreamTest() throws IOException {
        ss.readStream("src/test/resources/sample2.txt");
        assertTrue(true);

    }
}
