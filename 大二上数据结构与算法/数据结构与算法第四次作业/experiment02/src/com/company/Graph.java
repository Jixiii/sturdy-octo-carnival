package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Graph implements GraphInterface{
    public Actor KB = new Actor("Kevin Bacon");
//    public Actor KB = new Actor("Bacon, Kevin");
    public Movie[] movies = new Movie[100000];
    public MyHash allActors = new MyHash();
    public int moviesNum;
    public MyQueue01 queue = new MyQueue01();
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
                if (actor.equals(allActors.find(actor))){
                    actor = allActors.find(actor);
                }else {
                    allActors.push(actor);
                }
                movies[moviesNum].insertActor(actor);
                stringBuffer.delete(0,stringBuffer.length());
            }else {
                stringBuffer.append(string.charAt(index));
            }
        }
        Actor actor = new Actor(stringBuffer.toString());
        if (actor.equals(allActors.find(actor))){
            actor = allActors.find(actor);
        }else {
            allActors.push(actor);
        }
        movies[moviesNum].insertActor(actor);
        moviesNum++;
    }

    public void showMovies(){
        for (int i = 0; i < moviesNum; i++) {
            movies[i].showStruct();
        }
    }

    public void update(){
        queue.enqueue(KB);
        Actor someone = (Actor) queue.dequeue();
        for (int i = 0; i < moviesNum; i++) {
            if (!isout[i]&&movies[i].hasSomeone(someone)){
                movies[i].setRelation(someone);//set relationship between the movie and the actor
                isout[i] = true;//set mark
                for (int j = 0; j < movies[i].sumOfActor; j++) {
                    if (!movies[i].actors[j].equals(someone)){
                        queue.enqueue(movies[i].actors[j]);
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            update01();
        }
    }

    public void update01(){
        Actor someone = (Actor) queue.dequeue();
        for (int i = 0; i < moviesNum; i++) {
            if (!isout[i]&&movies[i].hasSomeone(someone)){
                movies[i].setRelation(someone);//set relationship between the movie and the actor
                isout[i] = true;//set mark
                for (int j = 0; j < movies[i].sumOfActor; j++) {
                    if (!movies[i].actors[j].equals(someone)){
                        queue.enqueue(movies[i].actors[j]);
                    }
                }
            }
        }
    }

    public void findPath(String someone){
        Actor temp = new Actor(someone);
        if (temp.hashCode()<0||temp.hashCode()>26*26-1) {
            System.out.println("The name is illegal.");
        }
        if (temp.equals(allActors.find(temp))){     //someone exists
            temp = allActors.find(temp);
            if (temp.relatedTo!=null) {
                System.out.println(someone + "'s Bacon number is "+findPath(temp));
            }else {
                System.out.println("No path");
            }
        } else {
            System.out.println(someone+" doesn't exist.");
        }
    }

    //return the Bacon Number
    public int findPath(Actor someone) {
        Actor tempActor = someone.relatedTo;
        if (KB.equals(tempActor)) {
            System.out.println(someone + " was in " + someone.inMovie + " with " + tempActor);
            return 1;
        }else {
            System.out.println(someone + " was in " + someone.inMovie + " with " + tempActor);
            return  findPath(tempActor)+1;
        }
    }

    public Actor findSomeone(String someone){
        return findSomeone(new Actor(someone));
    }

    public Actor findSomeone(Actor someone){
        if (someone!=null){
            return allActors.find(someone);
        }
        return null;
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
