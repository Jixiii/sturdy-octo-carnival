package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.readin("D:\\Javaaaa\\数据结构与算法第四次作业\\Complex1.txt");
        graph.readin("D:\\Javaaaa\\数据结构与算法第四次作业\\Simple1.txt");
        graph.update();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wlecome to the Six Degree of Kevin Bacon.\n" +
                "if you tell me an actor's name, I'll connect them to Kevin Bacon " +
                "through the movies they've appeared in.\n");
        System.out.print("Actor's name (or All for everyone) ? ");
        String name = scanner.nextLine();
        while (name != "123"){
            graph.findPath(name);
            System.out.print("\nActor's name (or All for everyone) ? ");
            name = scanner.nextLine();
        }
    }
}
