package com.company;

import java.util.Objects;

public class Actor implements Vertex{
    public String name;
    public int baconNumber;
    public Movie[] movies;
    public Movie finalMovie;//by which edge the actor finally links to Kevin Bacon

    public Actor() {
        if (name=="Kevin Bacon"){
            baconNumber = 0;
        }else {
            baconNumber = Integer.MAX_VALUE;
        }
        movies = new Movie[10000];
    }

    public Actor(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Movie firstMovie(){
        return (Movie) movies[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        int result = ((int) name.charAt(0) - (int) 'A') * 26 * 26;
        result += ((int) name.charAt(1) - (int) 'a') * 26;
        result += (int) name.charAt(name.length() - 1) - (int) 'a';
        return result;
    }

    public boolean isInTheSameMovieWith(Actor a) {
        if (a==null){return false;}
        for (int i = 0; i < movies.length; i++) {
            if (a.equals(movies[i].toActor)){
                return true;
            }
        }
        return false;
    }

    public void deleteMovie(Movie del){
        if (del==null)return;
        int index = 0;
        for (; index < movies.length; index++) {
            if (del.equals(movies[index])){
                break;
            }
        }
        for (int i = index; i < movies.length; i++) {
            movies[i]=movies[i+1];
        }
    }

    public void deleteMovieToActor(Actor delActor){
        if ((delActor==null))return;
        int index = 0;
        for (;index < movies.length;index++){
            if (delActor.equals(movies[index].toActor)){
                deleteMovie(movies[index]);
            }
        }
    }
}
