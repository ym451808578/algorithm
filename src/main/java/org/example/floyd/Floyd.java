package org.example.floyd;

import java.util.Arrays;

/**
 * @author Castle
 * @Date 2021/6/21 14:44
 */
public class Floyd {
    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int INF = 65535;
        int[][] matrix = {{0, 5, 7, INF, INF, INF, 2},
                {5, 0, INF, 9, INF, INF, 3},
                {7, INF, 0, INF, 8, INF, INF},
                {INF, 9, INF, 0, INF, 4, INF},
                {INF, INF, 8, INF, 0, 5, 4},
                {INF, INF, INF, 4, 5, 0, 6},
                {2, 3, INF, INF, 4, 6, 0}};

        floyd(vertexes, matrix);
    }

    public static void floyd(char[] vertexes, int[][] matrix) {
        int[][] dis = matrix;
        int[][] pre = new int[vertexes.length][vertexes.length];

        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[i].length; j++) {
                pre[i][j] = i;
            }
        }

        for (int[] arr : dis) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("*****************");
        for (int[] arr : pre) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("********************");

        for (int crossIndex = 0; crossIndex < vertexes.length; crossIndex++) {
            for (int startIndex = 0; startIndex < vertexes.length; startIndex++) {
                for (int endIndex = 0; endIndex < vertexes.length; endIndex++) {
                    int len = dis[startIndex][crossIndex] + dis[crossIndex][endIndex];
                    if (len < dis[startIndex][endIndex]) {
                        dis[startIndex][endIndex] = len;
                        pre[startIndex][endIndex] = pre[crossIndex][endIndex];
                    }
                }
            }
        }

        for (int[] arr : dis) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("*****************");
        for (int[] arr : pre) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("********************");
    }
}
