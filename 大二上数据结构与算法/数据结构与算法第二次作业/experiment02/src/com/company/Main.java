package com.company;

public class Main {
    public static void main(String[] args) {
	    Maze maze = new Maze();
        maze.inputMap("D:\\Javaaaa\\数据结构与算法第二次作业\\lab2_data\\test.txt");
        maze.getPlayer().go();
    }
}
