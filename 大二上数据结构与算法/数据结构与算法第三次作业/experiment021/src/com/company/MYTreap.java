package com.company;

public class MYTreap implements MyTreeInterface {
    Node root;

    @Override
    public void insert(int insertValue) {
        insert(new Node(insertValue));
    }

    public void insert(Node insertNode){
        simpleInsert(insertNode);
        while (insertNode.ancestor!=null){
            if (insertNode.comparePriority(insertNode.ancestor)<=0){
                break;
            }
            if (insertNode.equals(insertNode.ancestor)){
                insertNode.exchange();
                insertNode=insertNode.ancestor;
            }else {
                if (insertNode.isLeftChild()) {
                    insertNode.rightRotation();
                } else if (insertNode.isRightChild()) {
                    insertNode.leftRotation();
                }
            }
        }
        if (insertNode.ancestor==null){
            root = insertNode;
        }
    }

    public void simpleInsert(Node insertNode) {
        if (root == null) {
            root = insertNode;
            return;
        }
        Node tempNode = root;
        while (true) {
            if (insertNode.value < tempNode.value) {
                if (tempNode.leftChild != null) {
                    tempNode = tempNode.leftChild;
                } else {
                    tempNode.setLeftChild(insertNode);
                    break;
                }
            } else if (insertNode.value >= tempNode.value) {
                if (tempNode.rightChild != null) {
                    tempNode = tempNode.rightChild;
                } else {
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
            delete(deleteNode);
        }
    }

    public void delete(Node deleteNode) {
        if (deleteNode == root) {
            if (deleteNode.isLeaf()) {
                root = null;
            } else {
                if (deleteNode.hasTwoChildren()) {
                    if (deleteNode.rightChild.comparePriority(deleteNode.leftChild) >= 0) {
                        root = deleteNode.rightChild;
                        deleteNode.rightChild.leftRotation();
                    } else {
                        root = deleteNode.leftChild;
                        deleteNode.leftChild.rightRotation();
                    }
                } else {
                    if (deleteNode.rightChild != null) {
                        root = deleteNode.rightChild;
                        deleteNode.rightChild.leftRotation();
                    } else {
                        root = deleteNode.leftChild;
                        deleteNode.leftChild.rightRotation();
                    }
                }
                delete(deleteNode);
            }
        } else {
            while (!deleteNode.isLeaf()) {
                if (deleteNode.hasTwoChildren()) {
                    if (deleteNode.rightChild.priority - deleteNode.leftChild.priority >= 0) {
                        deleteNode.rightChild.leftRotation();
                    } else {
                        deleteNode.leftChild.rightRotation();
                    }
                } else {
                    if (deleteNode.rightChild != null) {
                        deleteNode.rightChild.leftRotation();
                    } else if (deleteNode.leftChild != null) {
                        deleteNode.leftChild.rightRotation();
                    }
                }
            }
            if (deleteNode.isLeftChild()) {
                deleteNode.ancestor.setLeftChild(null);
            } else {
                deleteNode.ancestor.setRightChild(null);
            }
        }
    }


    @Override
    public Node find(int value) {
        return find(new Node(value));
    }

    @Override
    public Node find(Node findNode) {
        Node tempNode = root;
        while (!findNode.equals(tempNode)) {
            if (tempNode == null) {
                break;
            } else if (findNode.value < tempNode.value) {
                tempNode = tempNode.leftChild;
            } else {
                tempNode = tempNode.rightChild;
            }
        }
        return tempNode;
    }

    @Override
    public int treeHight() {
        return root.hight();
    }

    public void showStruct() {
        if (root == null) {
            return;
        }
        Node[] elements = new Node[100000];
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
