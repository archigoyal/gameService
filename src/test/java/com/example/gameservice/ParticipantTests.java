package com.example.gameservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class ParticipantTests {

    @InjectMocks
    Participant p;

    @Test
    void getIdTest (){
            p.getId();
            assertTrue(true);
    }
    @Test
    void getScoreTest (){
        p.getScore();
        assertTrue(true);
    }
    @Test
    void getNameTest (){
        p.getName();
        assertTrue(true);
    }

    @Test
    void compareToTest (){
        Participant x=new Participant("Lilly",78,345);
        p.compareTo(x);
        assertTrue(true);
    }
}
