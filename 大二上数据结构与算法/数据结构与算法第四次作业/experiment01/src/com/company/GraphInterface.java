package com.company;

public interface GraphInterface {
    public Movie first(Actor v);//Get first movie for actor

    public Movie next(Movie m);//Get next edge for a vertex

    public boolean isMovie(Movie m);//True if this is an edge

    public boolean isMovieExist(Actor i, Actor j);//True if this is an edge

    public Actor fromActor(Movie m);//Where edge came from

    public Actor toActor(Movie m);//Where edge goes to

    public void delMovie(Movie m);//delete edge w

    public void delMovie(Actor i, Actor j);//delete edge(i,j)

    public void setMark(Actor a, int val);//Set Mark for v

    public int getMark(Actor v);//Get Mark for v
}
