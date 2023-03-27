package com.company;

public class Main {

    public static void main(String[] args) {
        Llist llist = new Llist();
        llist.showStructure();
        llist.insert("a");
        llist.showStructure();
        llist.insert("b");
        llist.showStructure();
        llist.remove();
        llist.showStructure();
        llist.insert("c");
        llist.showStructure();
        llist.insert("f");
        llist.showStructure();
        System.out.println(llist.curr.next());
        llist.gotoNext();
        System.out.println(llist.curr.next());
        llist.showStructure();
//        llist.insert("d");
//        llist.showStructure();
//        llist.gotoPrev();
//        llist.showStructure();
//        llist.insert("e");
//        llist.showStructure();
    }
}
