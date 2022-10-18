package com.example.gameservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecordStoringService {

    @Autowired
    MongoService ms;

    static SortedSet<Participant> topper = new TreeSet<>();
    static HashMap<Integer, Participant> mapOfPeople = new HashMap<>();

    public void insert(Participant p) {

        if (topper.size() < 5) add(p);
        else upsert(p);
    }

    public Participant findMax(ArrayList<Participant> listOfParticipants) {
        Participant p = new Participant();
        int max = Integer.MIN_VALUE;
        for (Participant x : listOfParticipants) {
            if (x.getScore() > max && !mapOfPeople.containsKey(x.getId())) {
                max = x.getScore();
                p = x;
            }
        }

        return p;
    }

    public SortedSet<Participant> getTopper() {
        return topper;
    }

    public void add(Participant p) {

        if (mapOfPeople.containsKey(p.getId()))
            topper.remove((mapOfPeople.get(p.getId())));
        mapOfPeople.put(p.getId(), p);
        topper.add(p);
    }

    public void upsert(Participant p) {
        int min = topper.last().getScore();
        if (!mapOfPeople.containsKey(p.getId())) {
            if (p.getScore() > min) {
                int id = topper.last().getId();
                topper.remove(topper.last());
                mapOfPeople.remove(id);
                topper.add(p);
                mapOfPeople.put(p.getId(), p);
            }
        } else {

            if (p.getScore() > min) {

                topper.remove(mapOfPeople.get(p.getId()));
                mapOfPeople.put(p.getId(), p);
                topper.add(p);

            } else {
                ArrayList<Participant> listOfParticipants = ms.getHighest(topper.last().getId(), topper.last().getScore(), p.getId(), p.getScore());
                topper.remove(mapOfPeople.get(p.getId()));
                mapOfPeople.remove(p.getId());
                Participant maxP = findMax(listOfParticipants);
                topper.add(maxP);
                mapOfPeople.put(maxP.getId(), maxP);
            }
        }
    }

}
