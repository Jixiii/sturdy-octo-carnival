package com.company;

public class MyStack {
    Position[] positions = new Position[100000];
    int top;//栈顶的上一个

    public Position pop() {
        if (!isEmpty()) {
            return positions[--top];
        }
        return null;
    }

    public void push(Position position) {
        if (!isFull()) {
            positions[top++] = position;
        }
    }

    public boolean isFull() {
        return top >= 100000;
    }

    public boolean isEmpty() {
        return top == 0;
    }

}
