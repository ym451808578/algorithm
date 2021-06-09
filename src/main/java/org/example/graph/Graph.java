package org.example.graph;

import java.util.*;

/**
 * @author Castle
 * @Date 2021/6/8 9:15
 */
public class Graph {

    /**
     * 顶点列表
     */
    private List<String> vertexList;
    /**
     * 边
     */
    private int[][] edges;
    /**
     * 边的数量
     */
    private int numOfEdges;


    /**
     * 初始化
     *
     * @param n
     */
    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }

    /**
     * 获取顶点的数量
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 获取边的数量
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回节点index对应的顶点
     *
     * @param index
     * @return
     */
    public String getVertexByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回value1和value2的权值
     *
     * @param value1
     * @param value2
     * @return
     */
    public int getWeight(int value1, int value2) {
        return edges[value1][value2];
    }

    /**
     * 插入顶点
     *
     * @param vertex
     */
    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     *
     * @param value1
     * @param value2
     * @param weight
     */
    public void addEdge(int value1, int value2, int weight) {
        edges[value1][value2] = weight;
        edges[value2][value1] = weight;
        numOfEdges++;
    }

    /**
     * 将表示图的二维数组打印出来
     */
    public void show() {
        for (int[] arr : edges) {
            System.out.println(Arrays.toString(arr));
        }
    }


    /**
     * 获取第一个邻接点
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻接点的下标获取下一个邻接点
     *
     * @param currentIndex
     * @param neighborIndex
     * @return
     */
    public int getNextNeighbor(int currentIndex, int neighborIndex) {
        for (int i = neighborIndex + 1; i < vertexList.size(); i++) {
            if (edges[currentIndex][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     *
     * @param isVisited
     * @param index
     */
    private void dfs(boolean[] isVisited, int index) {
        System.out.print(getVertexByIndex(index) + "-->");
        isVisited[index] = true;
        int neighborIndex = getFirstNeighbor(index);
        while (neighborIndex != -1) {
            //如果邻接点未被访问过
            if (!isVisited[neighborIndex]) {
                dfs(isVisited, neighborIndex);
            }
            //如果邻接点已被访问过
            neighborIndex = getNextNeighbor(index, neighborIndex);
        }
    }

    public void dfs() {
        boolean[] isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先遍历
     *
     * @param isVisited
     * @param index
     */
    private void bfs(boolean[] isVisited, int index) {
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(getVertexByIndex(index) + "-->");
        queue.add(index);
        isVisited[index] = true;
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            int neighborIndex = getFirstNeighbor(head);
            while (neighborIndex != -1) {
                if (!isVisited[neighborIndex]) {
                    System.out.print(getVertexByIndex(neighborIndex) + "-->");
                    isVisited[neighborIndex] = true;
                    queue.add(neighborIndex);
                }
                neighborIndex = getNextNeighbor(head, neighborIndex);
            }
        }
    }

    public void bfs() {
        boolean[] isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }
}
