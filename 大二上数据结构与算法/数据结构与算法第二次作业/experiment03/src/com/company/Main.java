package com.company;

public class Main {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort(10,10,
                "D:\\Javaaaa\\数据结构与算法第二次作业\\experiment03\\test03.txt");
        radixSort.scanIn();
        radixSort.sort();
        System.out.println(radixSort.getMyQueue());
    }
}
