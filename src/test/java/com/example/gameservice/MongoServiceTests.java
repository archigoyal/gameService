package com.example.gameservice;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.Part;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class MongoServiceTests {
    @Mock
    Participant p;

    @InjectMocks
    MongoService ms;
    @Test
    void addParticipantTest(){
        p=new Participant("Carrot",1,1);
        ms.addParticipant(p);
        assertTrue(true);
    }

    @Test
    void getHighestTest(){
        Integer maxId = 1;
        Integer maxScore= 100;
        Integer minId = 10;
        Integer minScore= 10;
        ms.getHighest(maxId,maxScore,minId,minScore);
        assertTrue(true);


    }



}
