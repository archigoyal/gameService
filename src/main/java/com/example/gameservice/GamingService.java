package com.example.gameservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Scanner;

@Service
public class GamingService {

    @Autowired
    StreamingService str ;

    @Autowired
    RecordStoringService rss;

    public void gamingService() throws IOException {
        System.out.println("Hello gamers!");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printResults();
            }
        });
        t1.start();
        str.readStream("src/main/resources/sample.txt");
        str.readStream("src/main/resources/sample3.txt");

    }
    public  void printResults(){
        System.out.println("Choose\n1. Get Score\n2. Exit");
        Scanner sc =new Scanner(System.in);
        Integer x=sc.nextInt();
        if(x==1){
            System.out.println("-----RESULTS-----------------");
            System.out.println("ID"+ "\t" +"Score"+"\t" +"Name");

            for(Participant p : rss.getTopper())
                System.out.println(p.getId()+ "\t" +p.getScore()+ "\t" +p.getName());
            printResults();
        }
        else if(x==2) {
            System.out.println("-----Exiting-----------------");
        }
        else System.out.println("-----Please enter a valid option-----------------");

    }
    @PostConstruct
    public void consumer() throws IOException{
        gamingService();
    }
}
