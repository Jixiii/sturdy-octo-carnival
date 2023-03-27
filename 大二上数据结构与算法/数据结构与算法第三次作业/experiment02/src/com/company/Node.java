package com.company;

import java.util.Random;

public class Node implements MyTreeInterface {
    Node root;
    int value;
    int priority;
    Node ancestor;
    Node leftChild;
    Node rightChild;
    int hight;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Node getAncestor() {
        return ancestor;
    }

    public void setAncestor(Node ancestor) {
        this.ancestor = ancestor;
        if (ancestor!=null) {
            if (this.value < ancestor.value) {
                ancestor.leftChild = this;
            } else {
                ancestor.rightChild = this;
            }
        }
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        if (leftChild!=null) {
            leftChild.ancestor = this;
        }
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        if (rightChild != null) {
            rightChild.ancestor = this;
        }
        this.rightChild = rightChild;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public Node() {
        priority = new Random().nextInt();
    }

    public Node(Node root) {
        this.root = root;
    }

    public Node(int value,Node root) {
        this(value);
        this.root=root;
    }

    public Node(int value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }


    @Override
    public void insert(int insertValue) {
        insert(new Node(insertValue,this.root));
    }

    public void insert(Node insertNode) {
        simpleInsert(insertNode);
//        showStruct();
        while (insertNode.ancestor!=null){
            if (insertNode.comparePriority(insertNode.ancestor)<=0){
                break;
            }
            if (insertNode.ancestor.rightChild==insertNode){
//                System.out.println("insertNode.ancestor.rightChild==insertNode");
                insertNode.rightRotation();
            }else if (insertNode.ancestor.leftChild==insertNode){
//                System.out.println("insertNode.ancestor.leftChild==insertNode");
                insertNode.leftRotation();
            }
        }
//        showStruct();
        if (insertNode.ancestor==null){
            System.out.println("insertNode.ancestor==null");
            root = insertNode;
        }
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

    public void simpleInsert(int insertValye) {
        simpleInsert(new Node(insertValye,this.root));
    }
    public void simpleInsert(Node insertNode) {
        if (root==null){
//            System.out.println("root==null");
            root=insertNode;
            return;
        }
//        System.out.println("root!=null");
        Node indexNode = root;
        while (indexNode.hasTwoChildren()) {
//            System.out.println("indexNode.hasTwoChildren()");
            if (insertNode.value < indexNode.value) {
                indexNode = indexNode.leftChild;
            } else {
                indexNode = indexNode.rightChild;
            }
        }
//        System.out.println("indexNode does not hasTwoChildren");
//        System.out.println("insertNode.value="+insertNode.value+" indexNode.value="+indexNode.value);
        if (insertNode.value < indexNode.value) {
//            System.out.println("insertNode.value < indexNode.value");
            if (indexNode.leftChild == null) {
                indexNode.leftChild = insertNode;
                insertNode.ancestor = indexNode;
            } else {
                indexNode.leftChild.insert(insertNode);
            }
        } else {
            if (indexNode.rightChild == null) {
                indexNode.rightChild = insertNode;
                insertNode.ancestor = indexNode;
            } else {
                indexNode.rightChild.insert(insertNode);
            }
        }
    }

    boolean hasTwoChildren() {
        return leftChild != null && rightChild != null;
    }

    boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public void delete(int deleteValue) {

    }

    @Override
    public Node find(int value) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    public void showStruct() {
        Node[] elements = new Node[10000];
        elements[0] = root;
        int length = 1;
        for (int i = 0; i <= root.hight(); i++) {
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
}
