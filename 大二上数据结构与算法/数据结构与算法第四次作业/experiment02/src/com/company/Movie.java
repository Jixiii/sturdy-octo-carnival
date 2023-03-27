package com.company;

import java.util.Objects;

public class Movie {
    public Actor[] actors = new Actor[1000];
    public int sumOfActor;
    public String movieName;

    public Movie() {
    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieName, movie.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName);
    }

    @Override
    public String toString() {
        return movieName;
    }

    public void insertActor(Actor actor) {
        actors[sumOfActor++] = actor;
    }

    public boolean hasSomeone(Actor someone) {
        if (someone==null)return false;
        for (int i = 0; i < sumOfActor; i++) {
            if (someone.equals(actors[i])){
                return true;
            }
        }
        return false;
    }

    public void showStruct() {
        System.out.print(this+" ");
        for (int i = 0; i < sumOfActor; i++) {
            System.out.print(actors[i] + " was in " + actors[i].inMovie + " with " + actors[i].relatedTo+"\n");
        }
        System.out.println();
    }

    public void setRelation(Actor someone) {
        for (int i = 0; i < sumOfActor; i++) {
            if (!actors[i].equals(someone)){
                actors[i].setRalationIn(this,someone);//set relationship between someone and everyone in the movie
            }
        }
    }
}