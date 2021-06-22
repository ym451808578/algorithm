package org.example.chess;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Castle
 * @Date 2021/6/22 9:59
 */
public class Chess {

    private static int X = 8;
    private static int Y = 8;

    private static boolean isFinished = false;

    private static boolean[] visited = new boolean[X * Y];

    public static void main(String[] args) {

        int[][] board = new int[X][Y];
        chess(board, 0, 0, 1);
        for (int[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void chess(int[][] board, int x, int y, int step) {
        board[x][y] = step;
        visited[y * X + x] = true;
        ArrayList<Point> nextPoints = getNextPoints(new Point(x, y));
        sort(nextPoints);
        while (!nextPoints.isEmpty()) {
            Point nextPoint = nextPoints.remove(0);
            if (!visited[nextPoint.getY() * X + nextPoint.getX()]) {
                chess(board, nextPoint.getX(), nextPoint.getY(), step + 1);
            }
        }
        if (step < X * Y && !isFinished) {
            board[x][y] = 0;
            visited[y * X + x] = false;
        } else {
            isFinished = true;
        }
    }

    public static ArrayList<Point> getNextPoints(Point currentPoint) {
        ArrayList<Point> pointList = new ArrayList<>();
        if (currentPoint.getX() - 2 >= 0 && currentPoint.getY() - 1 >= 0) {
            pointList.add(new Point(currentPoint.getX() - 2, currentPoint.getY() - 1));
        }
        if (currentPoint.getX() - 1 >= 0 && currentPoint.getY() - 2 >= 0) {
            pointList.add(new Point(currentPoint.getX() - 1, currentPoint.getY() - 2));
        }
        if (currentPoint.getX() + 1 < X && currentPoint.getY() - 2 >= 0) {
            pointList.add(new Point(currentPoint.getX() + 1, currentPoint.getY() - 2));
        }
        if (currentPoint.getX() + 2 < X && currentPoint.getY() - 1 >= 0) {
            pointList.add(new Point(currentPoint.getX() + 2, currentPoint.getY() - 1));
        }
        if (currentPoint.getX() + 2 < X && currentPoint.getY() + 1 < Y) {
            pointList.add(new Point(currentPoint.getX() + 2, currentPoint.getY() + 1));
        }
        if (currentPoint.getX() + 1 < X && currentPoint.getY() + 2 < Y) {
            pointList.add(new Point(currentPoint.getX() + 1, currentPoint.getY() + 2));
        }
        if (currentPoint.getX() - 2 >= 0 && currentPoint.getY() + 1 < Y) {
            pointList.add(new Point(currentPoint.getX() - 2, currentPoint.getY() + 1));
        }
        if (currentPoint.getX() - 1 >= 0 && currentPoint.getY() + 2 < Y) {
            pointList.add(new Point(currentPoint.getX() - 1, currentPoint.getY() + 2));
        }
        return pointList;
    }

    public static void sort(ArrayList<Point> points) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int nextSize1 = getNextPoints(o1).size();
                int nextSize2 = getNextPoints(o2).size();
                if (nextSize1 > nextSize2) {
                    return 1;
                } else if (nextSize1 < nextSize2) {
                    return -1;
                }
                return 0;
            }
        });
    }
}

@Data
@AllArgsConstructor
class Point {
    private int x;
    private int y;
}
