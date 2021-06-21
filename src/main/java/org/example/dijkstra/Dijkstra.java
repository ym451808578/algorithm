package org.example.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * @author Castle
 * @Date 2021/6/21 8:49
 */
public class Dijkstra {
    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int INF = Integer.MAX_VALUE;
        int[][] matrix = {{0, 5, 7, INF, INF, INF, 2},
                {5, 0, INF, 9, INF, INF, 3},
                {7, INF, 0, INF, 8, INF, INF},
                {INF, 9, INF, 0, INF, 4, INF},
                {INF, INF, 8, INF, 0, 5, 4},
                {INF, INF, INF, 4, 5, 0, 6},
                {2, 3, INF, INF, 4, 6, 0}};

        dijkstra(matrix, 6, vertexes);
    }

    public static void dijkstra(int[][] matrix, int startIndex, char[] vertexes) {
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[vertexes.length];
        //前驱顶点数组。即，prevVertex[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
        int[] prevVertex = new int[vertexes.length];
        //长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
        int[] dist = new int[vertexes.length];

        for (int i = 0; i < vertexes.length; i++) {
            flag[i] = false;
            if (matrix[startIndex][i] < Integer.MAX_VALUE) {
                prevVertex[i] = startIndex;
            }
            dist[i] = matrix[startIndex][i];
        }

        flag[startIndex] = true;


        //寻找最小路径的节点，作为下一个起始节点
        int minIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < vertexes.length; j++) {
                if (flag[j] == false && dist[j] < min && dist[j] != 0) {
                    min = dist[j];
                    minIndex = j;
                }
            }
            flag[minIndex] = true;

            // 当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < vertexes.length; j++) {
                int tmp = (matrix[minIndex][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + matrix[minIndex][j]));
                if (flag[j] == false && (tmp < dist[j])) {
                    dist[j] = tmp;
                    prevVertex[j] = minIndex;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}

@Data
@AllArgsConstructor
class Edge {
    private char start;
    private char end;
    private int weight;
}
