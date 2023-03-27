package com.company;

public class MyQueue implements MyQueueInterface{
    Node head;//头节点
    Node tail;//尾节点

    public MyQueue() {
    }

    @Override
    public String toString() {
        Node temp = head;
        StringBuffer string = new StringBuffer();
        while (temp!=null){
            string.append(temp.toString());
            temp = temp.next;
        }
        return string.toString();
    }

    @Override
    public Node dequeue() {
        if (!isEmpty()) {
            Node temp = head;
            head = head.next;
            return temp;
        }
        System.out.println("队列已空，不能出队");
        return null;
    }

    @Override
    public void enqueue(Node node) {
        if (!isFull()) {
            if (isEmpty()){
                head = tail = node;
            }else {
                tail = tail.next = node;
            }
            tail.next=null;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void showStruct() {
        System.out.println(this);
    }
}
