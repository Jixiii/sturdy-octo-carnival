package com.company;

public class Node {
    public int[] elements = new int[10000];
    public int lenght;
    Node next;

    public Node() {
    }

    public Node(int[] elements) {
        this();
        this.elements = elements;
        lenght = elements.length;
    }

    @Override
    public String toString() {
        if (lenght==0){
            return "";
        }
        StringBuffer string = new StringBuffer();
        for (int i = lenght-1; i >=0 ; i--) {
//            string.append((char) elements[i]);
            string.append(""+elements[i]);
        }
        string.append(' ');
        return string.toString();
    }
}
