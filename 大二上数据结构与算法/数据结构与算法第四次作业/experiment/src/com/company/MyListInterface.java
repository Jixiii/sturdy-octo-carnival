package com.company;

public interface MyListInterface <T>{
    public boolean isEmpty();
    public boolean isFull();
    public void append(T object);
    public T ObjectAt(int i);
    public void deleteAt(int i);
    public void deleteObject(T object);
    public int getLength();
}
