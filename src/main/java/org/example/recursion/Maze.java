package org.example.recursion;

import java.util.Arrays;

/**
 * @author Castle
 * @Date 2021/6/3 11:08
 */
public class Maze {
    public static void main(String[] args) {

        int[][] maze = new int[8][7];
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }

        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }

        maze[3][1] = 1;
        maze[3][2] = 1;
        maze[3][3] = 1;

        go(maze, 1, 1);
        for (int[] arr : maze) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static boolean go(int[][] maze, int i, int j) {
        if (maze[maze.length - 2][maze[0].length - 2] == 2) {
            return true;
        }
        if (maze[i][j] == 0) {
            maze[i][j] = 2;
            //向下走
            if (go(maze, i + 1, j)) {
                return true;
            } else if (go(maze, i, j + 1)) {
                return true;
            } else if (go(maze, i - 1, j)) {
                return true;
            } else if (go(maze, i, j - 1)) {
                return true;
            } else {
                maze[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}
