package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Graph implements GraphInterface{
    public Movie[] movies = new Movie[100000];
    public int moviesNum;
    public MyQueue<Actor> queue = new MyQueue();
    public boolean[] isout = new boolean[100000];

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
        int index = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (string.charAt(index)!='/'){
            stringBuffer.append(string.charAt(index));
            movies[moviesNum]=new Movie(stringBuffer.toString());
            index++;
        }
        index++;
        stringBuffer.delete(0,stringBuffer.length());
        for (; index < string.length(); index++) {
            if (string.charAt(index)=='/'){
                Actor actor = new Actor(stringBuffer.toString());
                movies[moviesNum].insertActor(actor);
                stringBuffer.delete(0,stringBuffer.length());
            }else {
                stringBuffer.append(string.charAt(index));
            }
        }
        Actor actor = new Actor(stringBuffer.toString());
        movies[moviesNum].insertActor(actor);
//        System.out.println(movies[moviesNum]);
//        System.out.println(movies[moviesNum].actors[0]);
//        movies[moviesNum].actors[0].showMovies();
        moviesNum++;
    }

    public void update(){
        boolean isChanged = false;
        queue.enqueue(new Actor("Kevin Bacon"));
        Actor someone = (Actor) queue.dequeue();
//        System.out.println(someone);
        for (int i = 0; i < moviesNum; i++) {
            if (!isout[i] && movies[i].hasSomeone(someone)) {
                isout[i] = true;
//                System.out.println(someone.baconNumber+1);
                movies[i].setBaconNum(someone.baconNumber+1);
                isChanged = true;
//                System.out.println(movies[i].actorsNumber);
                for (int j = 0; j < movies[i].actorsNumber; j++) {
//                    System.out.println("enqueue "+movies[i].actors[j]);
                    queue.enqueue(movies[i].actors[j]);
                }
                System.out.println(movies[i]+" movie baconnum = "+movies[i].baconNum);
            }
        }
        while (!queue.isEmpty()){
            update1();
        }
        if (isChanged){
//            System.out.println("isChanged");
            update1();
        }
//        System.out.println("==========");
//        for (int i = 0; i < moviesNum; i++) {
//            movies[i].showActors();
//        }
//        System.out.println(isChanged);
    }

    public void update1(){
        boolean isChanged = false;
        Actor someone = (Actor) queue.dequeue();
//        System.out.println(someone);
        if (someone==null){
            return;
        }
        for (int i = 0; i < moviesNum; i++) {
//            System.out.println(someone);
            if (!isout[i] && movies[i].hasSomeone(someone)) {
                isout[i] = true;
                movies[i].setBaconNum(someone.baconNumber+1);
                isChanged = true;
                for (int j = 0; j < movies[i].actorsNumber; j++) {
                    queue.enqueue(movies[i].actors[j]);
                }
                System.out.println(movies[i]+" movie baconnum = "+movies[i].baconNum);
            }
        }
        while (!queue.isEmpty()){
            update1();
        }
        if (isChanged){
            update1();
        }
    }



    @Override
    public Movie first(Actor v) {
        return null;
    }

    @Override
    public Movie next(Movie m) {
        return null;
    }

    @Override
    public boolean isMovie(Movie m) {
        return false;
    }

    @Override
    public boolean isMovieExist(Actor i, Actor j) {
        return false;
    }

    @Override
    public Actor fromActor(Movie m) {
        return null;
    }

    @Override
    public Actor toActor(Movie m) {
        return null;
    }

    @Override
    public void delMovie(Movie m) {

    }

    @Override
    public void delMovie(Actor i, Actor j) {

    }

    @Override
    public void setMark(Actor a, int val) {

    }

    @Override
    public int getMark(Actor v) {
        return 0;
    }
}
