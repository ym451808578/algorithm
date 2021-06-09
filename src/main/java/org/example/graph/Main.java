package org.example.graph;

/**
 * @author Castle
 * @Date 2021/6/8 11:07
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexes = {"A", "B", "C", "D", "E"};
        for (String s : vertexes) {
            graph.addVertex(s);
        }
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.show();

        graph.dfs();
        System.out.println("***************");

        graph.bfs();
        System.out.println();
    }
}
