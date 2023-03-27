package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Queue;

public class Graph implements GraphInterface {
    public MyHash actors = new MyHash();
    public MyQueue<Actor> queue;
    public int numberOfActors;
    public int numberOfMovies;

    public int getNumberOfActors() {
        return numberOfActors;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    @Override
    public Movie first(Actor v) {
        return v.firstMovie();
    }

    @Override
    public Movie next(Movie m) {
        return m.nextMovie();
    }

    @Override
    public boolean isMovie(Movie m) {
        if (m == null || Movie.class != m.getClass()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isMovieExist(Actor i, Actor j) {
        if (i == null || j == null) return false;
        return i.isInTheSameMovieWith(j);
    }

    @Override
    public Actor fromActor(Movie m) {
        return m.fromActor;
    }

    @Override
    public Actor toActor(Movie m) {
        return m.toActor;
    }

    @Override
    public void delMovie(Movie m) {
        m.fromActor.deleteMovie(m);
    }

    @Override
    public void delMovie(Actor i, Actor j) {
        if (i == null || j == null) return;
        i.deleteMovieToActor(j);
    }

    @Override
    public void setMark(Actor a, int val) {

    }

    @Override
    public int getMark(Actor v) {
        return 0;
    }

    public void readin(String filename) {
        Reader reader = null;
        try {
            reader = new FileReader(filename);
            int characterNumber = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                characterNumber = reader.read();
                if (characterNumber == -1) {
                    break;
                }else if (characterNumber == 13){
                    readLine(stringBuffer.toString());
                    characterNumber = reader.read();
                    stringBuffer.delete(0, stringBuffer.length());
                }else {
                    stringBuffer.append((char) characterNumber);
                }
            }
            readLine(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readLine(String string){
//        System.out.println(string);
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        while (string.charAt(index)!='/'){
            stringBuffer.append(string.charAt(index));
            index++;
        }
        Movie movie = new Movie(stringBuffer.toString());
        System.out.println(new Movie(stringBuffer.toString()));
        stringBuffer.delete(0,stringBuffer.length());
        index++;
        for (; index < string.length(); index++) {
            if (string.charAt(index)=='/'){
                actors.push(new Actor(stringBuffer.toString()));
                System.out.println(new Actor(stringBuffer.toString()));
                stringBuffer.delete(0,stringBuffer.length());
            }else {
                stringBuffer.append(string.charAt(index));
            }
        }
        actors.push(new Actor(stringBuffer.toString()));
        System.out.println(new Actor(stringBuffer.toString()));

    }
}
