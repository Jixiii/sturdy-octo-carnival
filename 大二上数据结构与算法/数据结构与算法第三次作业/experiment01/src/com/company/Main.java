package com.company;

public class Main {

    public static void main(String[] args) {
        Node tree = new Node();
        tree = tree.readPostBinaryTree("1 3 + 6 14 - * ");
        System.out.println("= "+tree.postorderResult());
        tree.output();
        tree = tree.readInBinaryTree("( 1 + 3 ) * ( 6 - 4 )");
        System.out.println("= "+tree.postorderResult());
        tree.output();
    }
}
