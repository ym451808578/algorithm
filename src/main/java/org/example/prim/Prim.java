package org.example.prim;

/**
 * @author Castle
 * @Date 2021/6/18 9:38
 */
public class Prim {
    public static void main(String[] args) {
        //最小权值，默认为无效
        int minValue = Integer.MAX_VALUE;
        //最小权值的顶点编号
        int minIndex = 0;
        int sum = 0;
        //顶点集合
        String[] vertex = new String[]{"A", "B", "C", "D", "E", "F"};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];

        //邻接矩阵初始化
        matrix[0] = new int[]{0, 7, 5, 1, minValue, minValue};
        matrix[1] = new int[]{7, 0, minValue, 6, 3, minValue};
        matrix[2] = new int[]{5, minValue, 0, 7, minValue, 2};
        matrix[3] = new int[]{1, 6, 7, 0, 6, 4};
        matrix[4] = new int[]{minValue, 3, minValue, 6, 0, 7};
        matrix[5] = new int[]{minValue, minValue, 2, 4, 7, 0};

        //最小权值的矩阵
        int[] minCosts = new int[vertex.length];
        int[] startVertex = new int[vertex.length];

        //初始化最小权值
        for (int i = 0; i < vertex.length; i++) {
            //所有点的起点赋值为0
            startVertex[i] = 0;
            //以0为起点到达各个顶点的权值
            minCosts[i] = matrix[0][i];
        }

        //挑选剩余的顶点,起始位1
        for (int i = 1; i < vertex.length; i++) {
            minValue = Integer.MAX_VALUE;
            //最小权值的顶点编号
            minIndex = 0;
            for (int j = 1; j < vertex.length; j++) {
                if (minCosts[j] != 0 && minCosts[j] < minValue) {
                    minValue = minCosts[j];
                    minIndex = j;
                }
            }
            sum += minValue;
            //将已加入MST的对应的权值赋值为0
            minCosts[minIndex] = 0;
            System.out.println("顶点：" + vertex[startVertex[minIndex]] + "; 当前最小值：" + minValue);

            for (int k = 0; k < vertex.length; k++) {
                ///用minIndex顶点到各个顶点的权值比较costs数组的值，若较小则替换，并更新起点为minIndex
                if (matrix[minIndex][k] != 0 && matrix[minIndex][k] < minCosts[k]) {
                    minCosts[k] = matrix[minIndex][k];
                    startVertex[k] = minIndex;
                }
            }
        }

        System.out.println("最终最小值合计：" + sum);
    }
}
