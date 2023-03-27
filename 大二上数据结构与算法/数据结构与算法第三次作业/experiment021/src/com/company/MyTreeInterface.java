package com.company;

public interface MyTreeInterface {
    void insert(int insertValue);

    void delete(int deleteValue);

    Node find(int value);

    Node find(Node findNode);

    int treeHight();
}