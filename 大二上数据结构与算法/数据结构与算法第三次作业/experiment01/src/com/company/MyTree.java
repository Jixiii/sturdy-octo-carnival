package com.company;

public interface MyTree {
    boolean isLeaf();

    Node readPostBinaryTree(String expression);

    int postorderResult();

    void output();

    Node readInBinaryTree(String expression);

    boolean isNumber();

    int hight();

    void updateDepth();
}
