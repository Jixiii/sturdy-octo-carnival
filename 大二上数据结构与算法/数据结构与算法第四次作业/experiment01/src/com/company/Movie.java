package com.company;

public class Movie {
    public Actor[] actors = new Actor[500];
    public int actorsNumber;
    public String name;
    public int baconNum;

    public Movie() {
        baconNum = Integer.MAX_VALUE;
    }

    public Movie(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void insertActor(Actor ins) {
        if (baconNum > ins.baconNumber) {
            baconNum = ins.baconNumber;
        }
        ins.insertMovie(this);
        actors[actorsNumber++] = ins;
    }

    public void showActors() {
        for (int i = 0; i < actorsNumber; i++) {
            System.out.println(actors[i] +" actor baconnum = "+actors[i].baconNumber);
        }
    }

    public boolean hasSomeone(Actor someone) {
        for (int i = 0; i < actorsNumber; i++) {
            if (someone.equals(actors[i])) {
                return true;
            }
        }
        return false;
    }

    public void setBaconNum(int num) {
        if (this.baconNum > num) {
            this.baconNum = num;
            for (int i = 0; i < actorsNumber; i++) {
//                System.out.println(actors[i]+" i = "+i);
                actors[i].setBaconNumber(num);
            }
        }
    }

}