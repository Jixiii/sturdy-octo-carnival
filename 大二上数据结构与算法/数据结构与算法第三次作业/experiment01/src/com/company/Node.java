package com.company;

public class Node implements MyTree {
    private Operation operation = Operation.NULL;
    private int vulue;
    private Node leftChild;
    private Node rightChild;
    private int hight;
    private int depth;

    public int compareTo(Node other){
        if (isNumber()){
            return this.vulue-other.vulue;
        }else {
            return this.priority()-other.priority();
        }
    }

    public int priority(){
        switch (operation){
            case RIGHTBRACKET:
                return 0;
            case ADDITION,SUBTRACTION:
                return 1;
            case MULTIPLICATION,DIVISION:
                return 2;
            case LEFTBRACKET:
                return 0;
            default:
                return 4;
        }
    }

    public Node() {
    }

    public Node(int vulue){
        this.vulue=vulue;
    }

    public Node(char element) {
        if ((int) element >= 48 && (int) element <= 57) {
            this.vulue = (int) element-48;
        } else {
            switch (element) {
                case '+':
                    this.operation = Operation.ADDITION;
                    break;
                case '-':
                    this.operation = Operation.SUBTRACTION;
                    break;
                case '*':
                    this.operation = Operation.MULTIPLICATION;
                    break;
                case '/':
                    this.operation = Operation.DIVISION;
                    break;
                case '(':
                    this.operation = Operation.LEFTBRACKET;
                    break;
                case ')':
                    this.operation = Operation.RIGHTBRACKET;
                    break;
                default:
                    this.operation=Operation.NULL;
            }
        }
    }

    @Override
    public String toString() {
        if (isNumber()) {
            return "" + vulue;
        }
        switch (operation) {
            case ADDITION:
                return "+";
            case SUBTRACTION:
                return "-";
            case MULTIPLICATION:
                return "*";
            case DIVISION:
                return "/";
            case RIGHTBRACKET:
                return ")";
            case LEFTBRACKET:
                return "(";
            default:
                return "";
        }
    }

    @Override
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    @Override
    public Node readPostBinaryTree(String expression) { //后缀表达式
        MyStack myStack = new MyStack();
        int tempNumber = 0;
        for (int i = 0; i < expression.length(); i++) {
            int tempCharNumber = (int) expression.charAt(i);
            if (tempCharNumber == (int)' ') {
                if ((int) expression.charAt(i-1)>=(int)'0'&&(int) expression.charAt(i-1)<=(int)'9') {
                    Node tempNode = new Node(tempNumber);
                    myStack.push(tempNode);
                    tempNumber = 0;
                }
            } else if (tempCharNumber>=(int)'0'&&tempCharNumber<=(int)'9'){
                tempNumber*=10;
                tempNumber+=tempCharNumber-(int)'0';
            }else {
                Node tempNode = new Node((char) tempCharNumber);
                tempNode.rightChild=myStack.pop();
                tempNode.leftChild=myStack.pop();
                myStack.push(tempNode);
                tempNumber=0;
            }
        }
        return myStack.pop();
    }

    @Override
    public int postorderResult() {
        if (this.isNumber()) {
            System.out.print(vulue+" ");
            return vulue;
        }
        int result = 0;
        switch (operation){
            case ADDITION:
                result= this.leftChild.postorderResult()+this.rightChild.postorderResult();
                System.out.print("+ ");
                break;
            case SUBTRACTION:
                result= this.leftChild.postorderResult()-this.rightChild.postorderResult();
                System.out.print("- ");
                break;
            case MULTIPLICATION:
                result = this.leftChild.postorderResult()*this.rightChild.postorderResult();
                System.out.print("* ");
                break;
            default:
                result = this.leftChild.postorderResult()/this.rightChild.postorderResult();
                System.out.print("/ ");
        }
        return result;
    }

    @Override
    public void output() {
        Node[] elements = new Node[10000];
        elements[0]=this;
        int length=1;
        for (int i = 0; i <= this.hight(); i++) {
            length *= 2;
        }
        for (int i = 1; i <= length; i++) {
            if (i % 2 == 0 && elements[i / 2-1] != null) {
                elements[i] = elements[i / 2-1].rightChild;
            }else if (i % 2 == 1 && elements[i / 2] != null) {
                elements[i] = elements[i / 2].leftChild;
            }
        }
        int blankNum = (length%2+length)/2;
        int newlineindex = 0;
        int index = 0;
        boolean isFirst=true;
        while (index<=length-2){
            if (isFirst){
                for (int i = 0; i < blankNum; i++) {    //打印元素前的空格
                    System.out.print(" ");
                }
                isFirst=false;
            }else {
                for (int i = 0; i < blankNum * 2 - 1; i++) {    //打印元素前的空格
                    System.out.print(" ");
                }
            }
            if (elements[index]==null){
                System.out.print("o");
            }else {
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

    @Override
    public Node readInBinaryTree(String expression) {//中缀表达式
        MyStack numberStack = new MyStack();
        MyStack operationStack = new MyStack();
        int tempNumber = 0;
        for (int i = 0; i < expression.length(); i++) {
            int tempCharNumber = (int) expression.charAt(i);
            if (tempCharNumber == (int) ' ') {
                if ((int) expression.charAt(i - 1) >= (int) '0' && (int) expression.charAt(i - 1) <= (int) '9') {
                    Node tempNode = new Node(tempNumber);
                    numberStack.push(tempNode);
                    tempNumber = 0;
                }
            } else if (tempCharNumber >= (int) '0' && tempCharNumber <= (int) '9') {
                tempNumber *= 10;
                tempNumber += tempCharNumber - (int) '0';
            } else {
                Node tempNode = new Node((char) tempCharNumber);
                if (tempNode.operation == Operation.LEFTBRACKET) {
                    operationStack.push(tempNode);
                } else if (tempNode.operation == Operation.RIGHTBRACKET) {
                    Node tempNumberNode = operationStack.pop();
                    while (tempNumberNode.operation != Operation.LEFTBRACKET) {
                        tempNumberNode.rightChild = numberStack.pop();
                        tempNumberNode.leftChild = numberStack.pop();
                        numberStack.push(tempNumberNode);
                        tempNumberNode = operationStack.pop();
                    }
                } else {
                    if (!operationStack.isEmpty()) {
                        if (tempNode.compareTo(operationStack.elements[operationStack.top - 1]) <= 0) {
                            Node tempNumberNode = operationStack.pop();
                            tempNumberNode.rightChild = numberStack.pop();
                            tempNumberNode.leftChild = numberStack.pop();
                            numberStack.push(tempNumberNode);
                        }
                    }
                    operationStack.push(tempNode);
                }
                tempNumber = 0;
            }
        }
        while (!operationStack.isEmpty()) {
            Node tempNumberNode = operationStack.pop();
            tempNumberNode.rightChild = numberStack.pop();
            tempNumberNode.leftChild = numberStack.pop();
            numberStack.push(tempNumberNode);
        }
        return numberStack.pop();
    }

    @Override
    public boolean isNumber() {
        return operation==Operation.NULL;
    }

    @Override
    public int hight() {
        if (isLeaf()) {
            return 0;
        }else if(hight!=0){
            return hight;
        }
        hight = Math.max(leftChild.hight(), rightChild.hight()) + 1;
        return hight;
    }

    @Override
    public void updateDepth() {
        this.depth=0;
        if (leftChild!=null){
            leftChild.updateDepth(this.depth);
        }
        if (rightChild!=null){
            rightChild.updateDepth(this.depth);
        }
    }

    public void updateDepth(int rootDepth) {
        this.depth=rootDepth+1;
        if (leftChild!=null){
            leftChild.updateDepth(this.depth);
        }
        if (rightChild!=null){
            rightChild.updateDepth(this.depth);
        }
    }
}
