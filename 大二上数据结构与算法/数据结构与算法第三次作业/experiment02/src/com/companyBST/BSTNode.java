package com.companyBST;

import com.company.MyTreeInterface;
import com.company.Node;

public class BSTNode implements MyTreeInterface {
    int value;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode() {
    }

    public BSTNode(int value) {
        this.value = value;
    }

    @Override
    public void insert(int insertValue) {
        insert(new BSTNode(insertValue));
    }

    private void insert(BSTNode insertNode) {
        BSTNode indexNode = this;
        while (indexNode.hasTwoChildren()) {
            if (insertNode.value < indexNode.value) {
                indexNode = indexNode.leftChild;
            } else {
                indexNode = indexNode.rightChild;
            }
        }
        if (insertNode.value < indexNode.value) {
            if (indexNode.leftChild == null) {
                indexNode.leftChild = insertNode;
            } else {
                indexNode.leftChild.insert(insertNode);
            }
        } else {
            if (indexNode.rightChild == null) {
                indexNode.rightChild = insertNode;
            } else {
                indexNode.rightChild.insert(insertNode);
            }
        }
    }

    boolean hasTwoChildren() {
        return leftChild != null && rightChild != null;
    }

    boolean isLeaf(){
        return leftChild==null&&rightChild==null;
    }

    @Override
    public void delete(int deleteValue) {

    }

    @Override
    public Node find(int value) {
        return null;
    }
}
