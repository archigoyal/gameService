package com.example.gameservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class StreamingService {

    @Autowired
    RecordStoringService rss;
    @Autowired
    MongoService ms;

    public void readStream(String path) throws IOException {
        File file=new File(path);    //creates a new file instance
        FileReader fr=new FileReader(file);   //reads the file
        BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
        String line;
        while((line=br.readLine())!=null) {
            String[] temp = line.split(" ");
            Participant n = new Participant(temp[0], Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
            ms.addParticipant(n);
            rss.insert(n);
        }
    }
}
