package com.company;

class MyHash01 {
    public Actor[] actors01 = new Actor[26 * 26 + 1];
//    public Actor[] actors02 = new Actor[26 * 26 + 1];
//    public Actor[] actors03 = new Actor[26 * 26 + 1];
//    public Actor[] actors04 = new Actor[26 * 26 + 1];
//    public Actor[] actors05 = new Actor[26 * 26 + 1];
//    public Actor[] actors06 = new Actor[26 * 26 + 1];
//    public Actor[] actors07 = new Actor[26 * 26 + 1];

    public void push(Actor a) {
        int index = a.hashCode();
        if (actors01[index] == null) {
            actors01[index] = a;
//        } else if (actors02[index] == null) {
//            actors02[index] = a;
//        }else if (actors03[index] == null) {
//            actors03[index] = a;
//        } else if (actors04[index] == null) {
//            actors04[index] = a;
//        }else if (actors05[index] == null) {
//            actors05[index] = a;
//        } else if (actors06[index] == null) {
//            actors06[index] = a;
//        }else if (actors07[index] == null) {
//            actors07[index] = a;
        }else {
            System.out.println("Too small");
        }
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
        if (a.equals(actors01[index])) {
            return actors01[index];
//        } else if (a.equals(actors02[index])) {
//            return actors02[index];
//        } else if (a.equals(actors03[index])) {
//            return actors03[index];
//        }else if (a.equals(actors04[index])) {
//            return actors04[index];
//        }else if (a.equals(actors05[index])) {
//            return actors05[index];
//        }else if (a.equals(actors06[index])) {
//            return actors06[index];
//        }else if (a.equals(actors07[index])) {
//            return actors07[index];
        }else {
            return null;
        }
    }
}
