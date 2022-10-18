package com.example.gameservice;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MongoService {
    public void addParticipant(Participant p) {

        Document document = new Document();
        document.append("_id", p.getId());
        Bson updates = Updates.combine(Updates.set("score", p.getScore()),
                Updates.set("name", p.getName()));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = DbConnection.c.updateOne(document, updates, options);
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
        }


    }

    public ArrayList<Participant> getHighest(Integer maxId, Integer maxScore, Integer minId, Integer minScore) {

        Bson filter = Filters.and(Filters.gte("score", minScore),
                Filters.lte("score", maxScore));
        FindIterable res = DbConnection.c.find(filter);
        ArrayList<Participant> listOfParticipant = new ArrayList<>();
        DbConnection.c.find(filter).forEach(doc -> listOfParticipant.add(new Participant(((String) doc.get("name")), ((Integer) doc.get("_id")), ((Integer) doc.get("score")))));
        return listOfParticipant;

    }
}
