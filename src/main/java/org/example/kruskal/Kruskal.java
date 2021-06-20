package org.example.kruskal;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * @author castle
 */
public class Kruskal {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] matrix = {{0, 12, max, max, max, 16, 14},
                {12, 0, 10, max, max, 7, max},
                {max, 10, 0, 3, 5, 6, max},
                {max, max, 3, 0, 4, max, max},
                {max, max, 5, 4, 0, 2, 8},
                {16, 7, 6, max, 2, 0, 9},
                {14, max, max, max, 8, 9, 0}};
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Edge[] edges = getEdges(matrix, vertexes);
        System.out.println(Arrays.toString(edges));
        sortEdges(edges);
        System.out.println(Arrays.toString(edges));

        int[] ends = new int[edges.length];
        Edge[] results = new Edge[vertexes.length - 1];
        int resultIndex = 0;
        for (int i = 0; i < edges.length; i++) {
            char start = edges[i].getStart();
            char end = edges[i].getEnd();

            int startPosition = getPosition(vertexes, start);
            int endPosition = getPosition(vertexes, end);

            int startEnd = getEnd(ends, startPosition);
            int endEnd = getEnd(ends, endPosition);
            if (startEnd != endEnd) {
                ends[startEnd] = endEnd;
                results[resultIndex++] = edges[i];
            }
        }

        for (Edge edge : results) {
            System.out.println(edge);
        }

    }

    /**
     * 根据矩阵和顶点集合获取边
     *
     * @param matrix
     * @param vertexes
     * @return
     */
    public static Edge[] getEdges(int[][] matrix, char[] vertexes) {
        int edgeNum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    edgeNum += 1;
                }
            }
        }
        Edge[] edges = new Edge[edgeNum];
        int edgeIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    Edge edge = new Edge(vertexes[i], vertexes[j], matrix[i][j]);
                    edges[edgeIndex++] = edge;
                }
            }
        }
        return edges;
    }

    /**
     * 对边进行排序，按照权重从小到大
     *
     * @param edges
     */
    public static void sortEdges(Edge[] edges) {
        Edge temp = null;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].getWeight() > edges[j + 1].getWeight()) {
                    temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 获取起点的位置坐标
     *
     * @param vertexes
     * @param start
     * @return
     */
    public static int getPosition(char[] vertexes, char start) {
        for (int i = 0; i < vertexes.length; i++) {
            if (start == vertexes[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取第i个顶点为起始点的终点位置
     *
     * @param ends
     * @param i
     * @return
     */
    public static int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

@Data
@AllArgsConstructor
class Edge {
    private char start;
    private char end;
    private int weight;
}
