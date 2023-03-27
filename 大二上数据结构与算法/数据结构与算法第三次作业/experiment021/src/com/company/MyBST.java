package com.company;

public class MyBST implements MyTreeInterface{
    Node root;

    @Override
    public void insert(int insertValue) {
        insert(new Node(insertValue));
    }

    public void insert(Node insertNode){
        if (root==null){
            root = insertNode;
            return;
        }
        Node tempNode = root;
        while (true){
            if (insertNode.value< tempNode.value){
                if (tempNode.leftChild!=null){
                    tempNode=tempNode.leftChild;
                }else {
//                    System.out.println("tempNode.setLeftChild("+insertNode+");");
                    tempNode.setLeftChild(insertNode);
                    break;
                }
            }else if (insertNode.value>= tempNode.value){
                if (tempNode.rightChild!=null){
                    tempNode=tempNode.rightChild;
                }else {
//                    System.out.println("tempNode.setRightChild("+insertNode+")");
                    tempNode.setRightChild(insertNode);
                    break;
                }
            }
        }
    }


    @Override
    public void delete(int deleteValue) {
        Node deleteNode = find(new Node(deleteValue));
        if (deleteNode!=null) {
//            System.out.println("deleteNode!=null");
            delete(deleteNode);
        }
    }

    public void delete(Node deleteNode){
        if (deleteNode==root) {
            if (deleteNode.rightChild != null) {
                root = root.rightChild;
            } else {
                root = root.leftChild;
            }
            return;
        }
        Node substitute = null;
        if (deleteNode.rightChild!=null) {
            substitute = deleteNode.rightChild.findMin();
            if (substitute.isLeftChild()) {
                substitute.ancestor.setLeftChild(null);
            } else if (substitute.isRightChild()) {
                substitute.ancestor.setRightChild(null);
            }
            if (deleteNode.isRightChild()) {
                deleteNode.ancestor.setRightChild(substitute);
            } else {
                deleteNode.ancestor.setLeftChild(substitute);
            }
        }else if (deleteNode.leftChild!=null){
            substitute = deleteNode.leftChild.findMax();
            if (substitute.isLeftChild()) {
                substitute.ancestor.setLeftChild(null);
            } else if (substitute.isRightChild()) {
                substitute.ancestor.setRightChild(null);
            }
            if (deleteNode.isRightChild()) {
                deleteNode.ancestor.setRightChild(substitute);
            } else {
                deleteNode.ancestor.setLeftChild(substitute);
            }
        }else { //deleteNode is a leaf
            if (deleteNode.isRightChild()) {
                deleteNode.ancestor.setRightChild(null);
            } else {
                deleteNode.ancestor.setLeftChild(null);
            }
        }
        /*
        if (deleteNode==root){
            if (deleteNode.hasTwoChildren()) {
                if (deleteNode.leftChild.comparePriority(deleteNode.rightChild) < 0) {
                    root = deleteNode.rightChild;
                    deleteNode.rightChild.leftRotation();
                } else {
                    root = deleteNode.leftChild;
                    deleteNode.leftChild.rightRotation();
                }
                delete(deleteNode);
            }else if (deleteNode.isLeaf()){
                root=null;
            }else {
                if (deleteNode.leftChild!=null){
                    root=deleteNode.leftChild;
                    root.ancestor=null;
                }else {
                    root=deleteNode.rightChild;
                    root.ancestor=null;
                }
            }
        }else if (deleteNode.isLeaf()){
            if (deleteNode.isLeftChild()){
                deleteNode.ancestor.setLeftChild(null);
            }else {
                deleteNode.ancestor.setRightChild(null);
            }
        }else if (deleteNode.hasTwoChildren()){
            System.out.println(deleteNode+"hasTwoChildren()");
            System.out.println("deleteNode.ancestor is "+deleteNode.ancestor);
            System.out.println("deleteNode.leftChild is "+deleteNode.leftChild);
            System.out.println("deleteNode.rightChild is "+deleteNode.rightChild);
            if (deleteNode.leftChild.comparePriority(deleteNode.rightChild)<0){
                deleteNode.rightChild.leftRotation();
                System.out.println(deleteNode+".rightChild.leftRotation();");
            }else {
                deleteNode.leftChild.rightRotation();
                System.out.println(deleteNode+".leftChild.rightRotation();");
            }
            System.out.println("deleteNode.ancestor is "+deleteNode.ancestor);
            System.out.println("deleteNode.leftChild is "+deleteNode.leftChild);
            System.out.println("deleteNode.rightChild is "+deleteNode.rightChild);
            delete(deleteNode);
        }else {
            if (deleteNode.isLeftChild()){
                deleteNode.ancestor.setLeftChild(deleteNode.leftChild==null?deleteNode.rightChild:deleteNode.leftChild);
            }else {
                deleteNode.ancestor.setRightChild(deleteNode.leftChild==null?deleteNode.rightChild:deleteNode.leftChild);
            }
        }*/

    }



    @Override
    public Node find(int value) {
        return find(new Node(value));
    }

    @Override
    public Node find(Node findNode) {
        Node tempNode = root;
        while (!findNode.equals(tempNode)){
            if (tempNode==null){
                break;
            }else if (findNode.value< tempNode.value){
                tempNode=tempNode.leftChild;
            }else {
                tempNode=tempNode.rightChild;
            }
        }
        return tempNode;
    }

    @Override
    public int treeHight() {
        return root.hight();
    }

    public void showStruct() {
        if (root==null){
            return;
        }
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
}
