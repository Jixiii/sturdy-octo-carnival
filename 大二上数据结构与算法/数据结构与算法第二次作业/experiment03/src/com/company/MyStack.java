package com.company;

public class MyStack implements MyStackInterface{
    public int[] elements = new int[100000];
    int top;//栈顶的上一个

    @Override
    public void push(int element) {
        elements[top]=element;
        top++;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public int pop() {
        top--;
        return elements[top];
    }

    @Override
    public boolean isFull() {
        return top<=100000;
    }

    @Override
    public void showStruct() {
        for (int i = 0; i < top; i++) {
            System.out.println(elements[i]);
        }
    }
}
