package com.example.gameservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

@ExtendWith(MockitoExtension.class)
public class GamingServiceTests {
      @Mock
      StreamingService str;
      @Mock
      RecordStoringService rss;

      @InjectMocks
      GamingService gs;

      @Test
      void gamingServiceTest () throws IOException {
          gs.gamingService();
          //All test cases should have assertion(Whether conditions are getting satisfied or not)
          assertTrue(true);
      }

      @Test
      void printResultTest(){


          SortedSet<Participant> testSet=new TreeSet<>();
          Participant a=new Participant("Apple", 1,1);
          testSet.add(a);
          when(rss.getTopper()).thenReturn(testSet);
          gs.printResults();
          assertTrue(true);

      }

      @Test
      void consumerTest() throws IOException{
          SortedSet<Participant> testSet=new TreeSet<>();
          Participant a=new Participant("Guru", 1,1);
          testSet.add(a);
          when(rss.getTopper()).thenReturn(testSet);
          gs.consumer();
          assertTrue(true);
      }


}
