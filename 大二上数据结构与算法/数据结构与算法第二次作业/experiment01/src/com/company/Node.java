package com.company;

public class Node {
    private char element;
    private Node below;

    public Node(char element, Node below) {
        this.element = element;
        this.below = below;
    }

    public Node(char element) {
        this.element = element;
    }

    public Node() {
    }

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    public Node getBelow() {
        return below;
    }

    public void setBelow(Node below) {
        this.below = below;
    }
}
