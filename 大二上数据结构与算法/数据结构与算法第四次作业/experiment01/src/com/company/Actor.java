package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Actor {
    public Movie[] movies = new Movie[1000];
    public int moviesNum;
    public String name;
    public int baconNumber;
    public Actor relatedTo;
    public Movie inMovie;

    public Actor() {
        baconNumber = Integer.MAX_VALUE;
    }

    public Actor(String name) {
        this();
        this.name = name;
        if (name == "Kevin Bacon"){
            baconNumber = 0;
        }else {
            baconNumber = Integer.MAX_VALUE;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public void insertMovie(Movie ins){
        if (baconNumber > ins.baconNum) {
            baconNumber = ins.baconNum;
        }
        movies[moviesNum++] = ins;
    }

    public void showMovies(){
        for (int i = 0; i < moviesNum; i++) {
            System.out.println(movies[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(moviesNum, name, baconNumber);
        result = 31 * result + Arrays.hashCode(movies);
        return result;
    }

    public void setBaconNumber(int number) {
        if (this.baconNumber>number) {
            this.baconNumber = number;
//            for (int i = 0; i < movies.length; i++) {
//                movies[i].setActorsNumber(number);
//            }
        }
    }
}
