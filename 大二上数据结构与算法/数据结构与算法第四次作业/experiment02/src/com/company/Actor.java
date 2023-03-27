package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Actor {
    public Movie inMovie;
    public Actor relatedTo;
    public String name;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
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
        int result = 0;
        int index = 1;
        if ((int)name.charAt(0)<=(int) 'Z'&&(int)name.charAt(0)>=(int) 'A'){
            result = (int) name.charAt(0)-(int) 'A';
        }else {
            while (index<name.length()){
                if ((int)name.charAt(index)<=(int) 'z'&&(int)name.charAt(index)>=(int) 'a') {
                    result = (int) name.charAt(index) - (int) 'a';
                    break;
                }
                index++;
            }
        }
        if (result<0) {
            System.out.println(name +" result1= "+ result +" index is "+ index);
        }
        result*=26;
        index = name.length()-1;
        while (index>=0){
            if ((int)name.charAt(index)<=(int) 'z'&&(int)name.charAt(index)>=(int) 'a') {
                result += (int) name.charAt(index) - (int) 'a';
                break;
            }
            index--;
        }
        if (result<0){
            System.out.println(name +" result= "+ result +" index is "+ index);
            return 0;
        }
        return result;
    }


    @Override
    public String toString() {
        return name;
    }

    public void setRalationIn(Movie movie, Actor someone) {
        inMovie = movie;
        relatedTo = someone;
    }
}
