package com.company;

public class MyQueue01 implements MyQueueInterface{
    public Node head;
    public Node tail;

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void enqueue(Object actor) {
        Node temp = new Node((Actor) actor);
        if (!isFull()){
            if (isEmpty()){
                head = tail = temp;
            }else {
                tail.next = temp;
                tail = temp;
            }
        }
    }

    @Override
    public Object dequeue() {
        Actor result = null;
        if (!isEmpty()){
            result = head.actor;
            head = head.next;
        }
        return result;
    }
}
