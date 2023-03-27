package com.company;

public interface MyQueueInterface<T>{
    public boolean isEmpty();
    public boolean isFull();
    public void enqueue(T object);
    public T dequeue();
}
