package com.company;

public interface MyQueueInterface {
    public Node dequeue();
    public void enqueue(Node node);
    public boolean isEmpty();
    public boolean isFull();
    public void showStruct();
}
