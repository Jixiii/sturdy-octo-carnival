package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RadixSort implements RadixSortInterface {
    int radix;
    MyQueue myQueue;
    int maxLenght;
    String filename;

    public int getRadix() {
        return radix;
    }

    public void setRadix(int radix) {
        this.radix = radix;
    }

    public MyQueue getMyQueue() {
        return myQueue;
    }

    public void setMyQueue(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public RadixSort() {
        myQueue = new MyQueue();
    }

    public RadixSort(int radix, int maxLenght, String filename) {
        this();
        this.radix = radix;
        this.maxLenght = maxLenght;
        this.filename = filename;
    }

    public void scanIn(){
        scanIn(filename);
    }
    @Override
    public void scanIn(String filename) {
        Reader reader = null;
        try {
            reader = new FileReader(filename);
            int characterNumber = 0;
            MyStack myStack = new MyStack();
            while ((characterNumber = reader.read()) != -1) {
                if ((char) characterNumber == ' ' || (char) characterNumber == '\n') {
                    Node tempNode = new Node();
                    while (!myStack.isEmpty()) {
                        tempNode.elements[tempNode.lenght++] = myStack.pop();
                    }
                    myQueue.enqueue(tempNode);
                } else if(characterNumber<=(int) '9'&&characterNumber>=(int)'0'){
                    myStack.push(characterNumber-(int)'0');
                }
            }
            Node tempNode = new Node();
            while (!myStack.isEmpty()) {
                tempNode.elements[tempNode.lenght++] = myStack.pop();
            }
            myQueue.enqueue(tempNode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sort() {
        sort(maxLenght);
    }

    @Override
    public void sort(int maxLenght) {
        for (int index = 0; index < maxLenght; index++) {
            radixsort(index);
        }
    }

    @Override
    public void radixsort(int index) {
        MyQueue[] mySortQueues = new MyQueue[radix];
        for (int i = 0; i < radix; i++) {
            mySortQueues[i]=new MyQueue();
        }
        while (!myQueue.isEmpty()) {
            Node tempNode = myQueue.dequeue();
            mySortQueues[tempNode.elements[index]].enqueue(tempNode);
        }
        for (int i = 0; i < radix; i++) {
            while (!mySortQueues[i].isEmpty()) {
                Node tempNode = mySortQueues[i].dequeue();
                myQueue.enqueue(tempNode);
            }
        }
    }
}
