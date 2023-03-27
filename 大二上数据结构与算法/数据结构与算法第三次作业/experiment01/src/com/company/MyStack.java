package com.company;

public class MyStack implements MyStackInterface {
    Node[] elements = new Node[100000];
    int top = 0;    //当前栈顶的上方


    @Override
    public boolean isFull() {
        return top > 100000;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public Node pop() {
        if (this.isEmpty()) {
            return null;
        }
        top--;
        return elements[top];
    }

    @Override
    public void push(Node node) {
        if (this.isFull()) return;
        top++;
        elements[top - 1] = node;
    }
}
