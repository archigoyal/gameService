package com.example.gameservice;

import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
public class DbConnection {
    DbConnection(){
        System.out.println("DB Connection initiated for database : " + Constants.DB_NAME  + " and collection : "+Constants.COLLECTION_NAME);
//        System.out.println(c);
    }
    static ConnectionString connectionString = new ConnectionString("mongodb+srv://"+Constants.USER_NAME+":"+Constants.PASSWORD+"@cluster0.gslq2o8.mongodb.net/?retryWrites=true&w=majority");
    static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build())
            .build();
    static MongoClient mongoClient = MongoClients.create(settings);
    static MongoDatabase database = mongoClient.getDatabase(Constants.DB_NAME);
    static MongoCollection<Document> c=database.getCollection(Constants.COLLECTION_NAME);
}
