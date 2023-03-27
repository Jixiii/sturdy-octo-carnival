package com.company;

class MyHash {
    public Actor[][] actors = new Actor[10000][26 * 26 + 1];
    public final int size = 10000;

    public void push(Actor a) {
        int index = a.hashCode();
        for (int i = 0; i < size; i++) {
            if (actors[i][index] == null){
                actors[i][index] = a;
                return;
            }
        }
        System.out.println("Too small");
    }

    public Actor find(Actor a) {
        if (a == null) {
            return null;
        }
        int index = a.hashCode();
        if (index < 0) {
            System.out.println(a);
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (a.equals(actors[i][index])) {
                return actors[i][index];
            }
        }
//        System.out.println(a+" Not exist");
        return null;
    }
}
