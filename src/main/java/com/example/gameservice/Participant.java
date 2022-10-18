package com.example.gameservice;

public class Participant implements Comparable<Participant> {

    private String name;
    private int id;
    private int score;

    Participant(String name, int id, int score){
        this.name=name;
        this.id=id;
        this.score=score;
    }

    public Participant() {

    }

    public int getId(){
        return  this.id;
    }
    public int getScore(){
        return this.score;

    }
    public String getName(){
        return this.name;
    }
    @Override
    public int compareTo(Participant p) {
        if(this.getId()!=p.getId()&&this.getScore() == p.getScore()) return 1;
        return  p.getScore()- this.getScore();
    }
}
