package com.company;

public class MyQueue<T> implements MyQueueInterface {
    T[] objects;
    int head;
    int tail=-1;
    int length = 50000000;

    public MyQueue() {
        this.objects = (T[]) new Object[50000000];
    }

    @Override
    public boolean isEmpty() {
        return (head - 1) % length == tail % length;
    }

    @Override
    public boolean isFull() {
        System.out.println("FULL");
        return (head - 2) % length == tail % length;
    }

    @Override
    public void enqueue(Object object) {
        if (!isFull()) {
//            System.out.println("!isFull");
            tail = (tail + 1) % length;
            objects[tail] = (T) object;

//            System.out.println(object);
        }
    }

    @Override
    public Object dequeue() {
        if (!isEmpty()) {
            T temp = objects[head];
//            System.out.println("temp = "+temp);
            head = (head + 1) % length;
            return temp;
        }
        return null;
    }
}
