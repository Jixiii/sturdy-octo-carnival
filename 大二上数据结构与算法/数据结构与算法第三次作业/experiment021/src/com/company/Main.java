package com.company;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		MYTreap myTreap = new MYTreap();
		MyBST myBST = new MyBST();
		long startTime, endTime;
		int size = 1000;
		Random random = new Random();

		System.out.println("顺序序列：");

		for (size = 1000; size <= 100000; size *= 10) {
			System.out.println("size = " + size + " 时:");
			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myBST.insert(i);
			}
			endTime = System.currentTimeMillis();
			System.out.print("BST: 插入耗时：" + (endTime - startTime) + "s   ");

//			try {
//				System.out.print("树高："+myBST.root.hight());
//			}catch (Exception e){
//				System.out.print("树高：99999");
//			}
			if (size<=10000) {
				System.out.print("树高：" + myBST.root.hight());
			}else {
				System.out.print("树高：99999");
			}

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myBST.find(i);
			}
			endTime = System.currentTimeMillis();
			System.out.print("   查找耗时：" + (endTime - startTime) + "s   ");

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myBST.delete(i);
			}
			endTime = System.currentTimeMillis();
			System.out.println("删除耗时：" + (endTime - startTime) + "s");
		}

		for (size = 1000; size <= 100000; size *= 10) {
			System.out.println("size = " + size + " 时:");
			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myTreap.insert(i);
			}
			endTime = System.currentTimeMillis();
			System.out.print("Treap: 插入耗时：" + (endTime - startTime) + "s   ");

			System.out.print("树高："+myTreap.root.hight());

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myTreap.find(i);
			}
			endTime = System.currentTimeMillis();
			System.out.print("   查找耗时：" + (endTime - startTime) + "s   ");

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myTreap.delete(i);
			}
			endTime = System.currentTimeMillis();
			System.out.println("删除耗时：" + (endTime - startTime) + "s");
		}


		System.out.println("-------------------------\n随机序列");

		for (size = 1000; size <= 100000; size *= 10) {
			System.out.println("size = " + size + " 时:");

			int[] elements = new int[size];
			for (int i = 0; i < size; i++) {
				elements[i] = random.nextInt(100000);
			}

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myBST.insert(elements[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.print("BST: 插入耗时：" + (endTime - startTime) + "s   ");

			System.out.print("树高："+myBST.root.hight());

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myBST.find(elements[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.print("   查找耗时：" + (endTime - startTime) + "s   ");

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myBST.delete(elements[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.println("删除耗时：" + (endTime - startTime) + "s");


			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myTreap.insert(elements[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.print("Treap: 插入耗时：" + (endTime - startTime) + "s   ");

			System.out.print("树高："+myTreap.root.hight());

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myTreap.find(elements[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.print("   查找耗时：" + (endTime - startTime) + "s   ");

			startTime = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				myTreap.delete(elements[i]);
			}
			endTime = System.currentTimeMillis();
			System.out.println("删除耗时：" + (endTime - startTime) + "s");
		}
	}
}
