package com.company;

public class MyHash {
    public Actor[] actors = new Actor[26 * 26 * 26 + 1];
    public boolean[] isDeleted = new boolean[26 * 26 * 26 + 1];

    public void push(Actor a) {
        int index = a.hashCode();
        if (actors[index]==null||isDeleted[index]==true){
            actors[index]=a;
        }else {

        }
    }
}
