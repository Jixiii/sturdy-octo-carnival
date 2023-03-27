package com.company;

public class MyQueue<T> implements MyQueueInterface {
    T[] objects;
    int start;
    int end;
    int length = 10000;

    public MyQueue() {
        this.objects = (T[]) new Object[10000];
    }

    @Override
    public boolean isEmpty() {
        return start % length == end % length;
    }

    @Override
    public boolean isFull() {
        return (start + 1) % length == end % length;
    }

    @Override
    public void enqueue(Object object) {
        if (!isFull()) {
//            System.out.println("!isFull");
            objects[end] = (T) object;
            end = (end + 1) % length;
//            System.out.println(object);
        }
    }

    @Override
    public Object dequeue() {
        if (!isEmpty()) {
            T temp = objects[start];
//            System.out.println("temp = "+temp);
            start = (start + 1) % length;
            return temp;
        }
        return null;
    }
}
