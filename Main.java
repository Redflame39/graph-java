package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        Scanner sc = new Scanner(System.in);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge('A', 'D', 8); // AD 8
        graph.addEdge('A', 'B', 5); // AD 8
        graph.addEdge('B', 'D', 9); // BD 9
        graph.addEdge('C', 'E', 4); // CE 4
        graph.addEdge('C', 'B', 6); // CE 4
        graph.addEdge('D', 'C', 2); // DC 2
        graph.addEdge('D', 'E', 7); // DE 7
        graph.addEdge('E', 'A', 5); //
        graph.addEdge('D', 'A', 1); //
        graph.addEdge('C', 'A', 1); //
        List paths = graph.path('A', 'C');
        while (true) {
            System.out.println("\n1. Добавить вершину\n2. Добавить ребро\n3. Вывести матрицу\n4. Найти путь\n5. Центр\n6. Выход");
            switch (sc.next()) {
                case "1":
                    System.out.print("Введите новую вершину: ");
                    char vert = (char) System.in.read();
                    graph.addVertex(vert);
                    System.out.println("Вершина " + vert + " добавлена.");
                    break;
                case "2":
                    System.out.print("Из: ");
                    char from = (char) System.in.read();
                    System.in.read();
                    System.out.print("В: ");
                    char to = (char) System.in.read();
                    System.out.print("Вес: ");
                    int weight = sc.nextInt();
                    graph.addEdge(from, to, weight);
                    System.out.println();
                    break;
                case "3":
                    graph.showAdjMatrix();
                    break;
                case "99":
                    System.out.print("Введите вершину:");
                    vert = (char) System.in.read();
                    graph.removeVertex(vert);

                    break;
                case "4":
                    paths.clear();
                    System.out.print("Из: ");
                    from = (char) System.in.read();

                    System.in.read();
                    System.out.print("В: ");
                    to = (char) System.in.read();
                    paths = graph.path(from, to);
                    System.out.println("1. Кратчайший\n2. Самый длинный\n3. Все пути\n4. Назад");
                    switch (sc.next()) {
                        case "1":
                            if (paths.isEmpty()) {
                                System.out.println("Не существует.");
                            } else
                                System.out.println(paths.getFirst().path);
                            break;
                        case "2":
                            if (paths.isEmpty()) {
                                System.out.println("Не существует.");
                            } else
                                System.out.println(paths.getLast().path);
                            break;
                        case "3":
                            if (paths.isEmpty()) {
                                System.out.println("Не существует.");
                            } else
                                paths.displayList();
                            break;
                        case "4":
                            break;
                    }
                    break;

                case "5":
                    System.out.println("Центр - " + graph.center());
                    break;
                case "6":
                    System.exit(0);
            }
        }
    }
}
