package com.company;

import java.util.Objects;

public class Movie implements Edge{
    public String movieName;
    public Actor fromActor;
    public Actor toActor;

    public Movie() {
    }
    public Movie(String movieName) {
        this.movieName = movieName;
    }

    public Movie nextMovie() {
        for (int i = 0; i < fromActor.movies.length; i++) {
            if (this.equals(fromActor.movies[i])) {
                return fromActor.movies[i + 1];
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieName, movie.movieName) && Objects.equals(fromActor, movie.fromActor) && Objects.equals(toActor, movie.toActor);
    }

    @Override
    public String toString() {
        return movieName + " from " + fromActor + " to " + toActor;
    }
}
