package com.company;

public class Node <T>{
    private  T element;     //节点储存的元素
    private  Node next;     //节点的后继
    private Node previous;  //节点的前驱

    public Node() {
    }

    public Node(T element, Node next, Node previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
