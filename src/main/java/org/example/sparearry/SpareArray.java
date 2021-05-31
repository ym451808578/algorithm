package org.example.sparearry;

/**
 * 　数组和稀疏数组的转换
 *
 * @author castle
 */
public class SpareArray {

    public static void main(String[] args) {
        //模拟一个11*11的棋盘
        int[][] chessArray = new int[11][11];
        //1表示白子
        chessArray[1][2] = 1;
        //2表示黑子
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        System.out.println("******转换前的棋盘******");
        //遍历原棋盘，计算总共几个棋子
        int count = 0;
        for (int[] arr : chessArray) {
            for (int data : arr) {
                if (data != 0) {
                    count++;
                }
                System.out.print(data + " ");
            }
            System.out.println();
        }
        System.out.println("*********************");
        System.out.println("共有棋子：" + count);

        int[][] spareChessArray = new int[count + 1][3];
        spareChessArray[0][0] = chessArray.length;
        spareChessArray[0][1] = chessArray[0].length;
        spareChessArray[0][2] = count;
        int flag = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    flag++;
                    spareChessArray[flag][0] = i;
                    spareChessArray[flag][1] = j;
                    spareChessArray[flag][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("******转换的稀疏数组为******");
        for (int[] arr : spareChessArray) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("**************************");
        int[][] newChessArray = new int[spareChessArray[0][0]][spareChessArray[0][1]];

        for (int i = 1; i < spareChessArray.length; i++) {
            newChessArray[spareChessArray[i][0]][spareChessArray[i][1]] = spareChessArray[i][2];
        }
        System.out.println("*******还原为普通数组******");
        for (int[] arr : newChessArray) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
