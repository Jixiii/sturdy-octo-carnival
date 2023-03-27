package com.company;

public class MyStack {
    private Node top;
    private int length;

    public MyStack() {
        top = null;
        length = 0;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    void push(char element){
        top = new Node(element,top);
        length++;
    }

    char pop(){
        if (length==0){
            throw new IndexOutOfBoundsException("栈空，不能弹栈");
        }
        length--;
        char temp = top.getElement();
        top = top.getBelow();
        return temp;
    }

    void showStruct(){
        Node temp = top;
        for (int i = 0; i < length; i++) {
            System.out.print(temp.getElement()+" ");
            temp=temp.getBelow();
        }
        System.out.println();
    }
}
