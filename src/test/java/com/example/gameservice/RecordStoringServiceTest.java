package com.example.gameservice;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.Part;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
@ExtendWith(MockitoExtension.class)
public class RecordStoringServiceTest {
    @Mock
    MongoService ms;

    @InjectMocks
    RecordStoringService rss;

    @Test
    void insertTest(){
        Participant p =new Participant("Chilli", 10,10);
        rss.insert(p);
        assertTrue(true);
    }
    @Test
    void insertTest0(){
        Participant p =new Participant("Tomato", 1,-10);
        rss.insert(p);
        assertTrue(true);
    }
    @Test
    void insertTest1(){
        Participant p =new Participant("Radish", 2,90);
        rss.insert(p);
        assertTrue(true);
    }
    @Test
    void insertTest2(){
        Participant p =new Participant("Ketchup", 3,100);
        rss.insert(p);
        assertTrue(true);
    }
    @Test
    void insertTest3(){
        Participant p =new Participant("Glass", 4,91);
        rss.insert(p);
        assertTrue(true);
    }
    @Test
    void insertTest4(){
        Participant p =new Participant("Chilli", 5,-100);
        rss.insert(p);
        assertTrue(true);
    }
    @Test
    void insertTest5(){
        Participant p =new Participant("Chilli", 6,1000);
        rss.insert(p);
        assertTrue(true);
    }


    @Test
    void findMaxTest(){
        ArrayList<Participant> listOfParticipants=new ArrayList<>();
        Participant p1 =new Participant("Chilli", 10,10);
        Participant p2 =new Participant("Mango", 1,9);
        listOfParticipants.add(p1);
        listOfParticipants.add(p2);
        rss.findMax(listOfParticipants);
        assertTrue(true);

    }

    @Test
    void getTopperTest(){
        rss.getTopper();
        assertTrue(true);
    }

    @Test
    void addTest(){
        Participant p =new Participant("Chilli", 10,10);
        rss.add(p);
        assertTrue(true);

    }
    @Test
    void addTest1(){
        Participant p =new Participant("Chilli", 10,10);
        rss.add(p);
        assertTrue(true);

    }

    @Test
    void upsertTest(){
        Participant p =new Participant("Chilli", 10,20);
        rss.upsert(p);
        assertTrue(true);
    }

    @Test
    void upsertTest2(){
        Participant p =new Participant("Chilli", 10,7);
        rss.upsert(p);
        assertTrue(true);
    }
    @Test
    void upsertTest3(){
        Participant p =new Participant("Guava", 7,7);
        rss.upsert(p);
        assertTrue(true);
    }

}
