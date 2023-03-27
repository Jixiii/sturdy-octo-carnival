package com.company;

import java.util.Random;

public class Node {
    int value;
    int priority;
    Node ancestor;
    Node leftChild;
    Node rightChild;
    int hight;

    public void setAncestor(Node setAncestor) {
        this.ancestor = setAncestor;
        if (setAncestor!=null) {
            if (this.value < setAncestor.value) {
                setAncestor.leftChild = this;
            } else {
                setAncestor.rightChild = this;
            }
        }
    }

    public void setLeftChild(Node setLeftChild) {
        if (setLeftChild!=null) {
            setLeftChild.ancestor = this;
        }
        this.leftChild = setLeftChild;
    }

    public void setRightChild(Node setRightChild) {
        if (setRightChild != null) {
            setRightChild.ancestor = this;
        }
        this.rightChild = setRightChild;
    }

    public Node() {
        priority = new Random().nextInt();
    }

    public Node(int value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
//        return "" + value +"->"+priority;
        return "" + value;
    }

    boolean hasTwoChildren() {
        return leftChild != null && rightChild != null;
    }

    boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    public void showStruct() {
        Node[] elements = new Node[100000];
        elements[0] = this;
        int length = 1;
        for (int i = 0; i <= this.hight(); i++) {
            length *= 2;
        }
        for (int i = 1; i <= length; i++) {
            if (i % 2 == 0 && elements[i / 2 - 1] != null) {
                elements[i] = elements[i / 2 - 1].rightChild;
            } else if (i % 2 == 1 && elements[i / 2] != null) {
                elements[i] = elements[i / 2].leftChild;
            }
        }
        int blankNum = (length % 2 + length) / 2;
        int newlineindex = 0;
        int index = 0;
        boolean isFirst = true;
        while (index <= length - 2) {
            if (isFirst) {
                for (int i = 0; i < blankNum; i++) {    //打印元素前的空格
                    System.out.print(" ");
                }
                isFirst = false;
            } else {
                for (int i = 0; i < blankNum * 2 - 1; i++) {    //打印元素前的空格
                    System.out.print(" ");
                }
            }
            if (elements[index] == null) {
                System.out.print("o");
            } else {
                System.out.print(elements[index]);
            }
            if (index == newlineindex) {
                System.out.println();
                newlineindex = (newlineindex + 2) * 2 - 2;
                blankNum /= 2;
                isFirst = true;
            }
            index++;
        }
    }

    public int hight() {
        if (isLeaf()){
            return 0;
        }else {
            int leftChildHight = 0;
            int rightChildHight = 0;
            if (leftChild != null) {
                leftChildHight = leftChild.hight();
            }
            if (rightChild != null) {
                rightChildHight = rightChild.hight();
            }
            this.hight = Math.max(leftChildHight, rightChildHight) + 1;
            return this.hight;
        }
    }

    public int comparePriority(Node competitor){
        return this.priority-competitor.priority;
    }
    public void rightRotation(){
            Node tempAncestor = this.ancestor;
            tempAncestor.setLeftChild(this.rightChild);
            this.setAncestor(tempAncestor.ancestor);
            this.setRightChild(tempAncestor);
    }

    public void leftRotation(){
        Node tempAncestor = this.ancestor;
        tempAncestor.setRightChild(this.leftChild);
        this.setAncestor(tempAncestor.ancestor);
        this.setLeftChild(tempAncestor);
    }

    public boolean isLeftChild(){
        if (this.ancestor==null){
            return false;
        }else {
            return this==this.ancestor.leftChild;
//            if (this.value<this.ancestor.value){
//                return true;
//            }else {
//                return false;
//            }
        }
    }

    public boolean isRightChild(){
        if (this.ancestor==null){
            return false;
        }else {
            return this==this.ancestor.rightChild;
//            if (this.value>=this.ancestor.value){
//                return true;
//            }else {
//                return false;
//            }
        }
    }

    public Node findMin(){
        Node min = this;
        while (min.leftChild!=null){
            min = min.leftChild;
        }
        return min;
    }

    public Node findMax(){
        Node max = this;
        while (max.rightChild!=null){
            max = max.rightChild;
        }
        return max;
    }

    public void exchange(){
        int tempPriority = this.priority;
        this.priority=this.ancestor.priority;
        this.ancestor.priority=tempPriority;
    }


}
