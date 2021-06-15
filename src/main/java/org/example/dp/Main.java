package org.example.dp;

import java.sql.Statement;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Castle
 * @Date 2021/6/15 9:15
 */
public class Main {
    public static void main(String[] args) {
        Goods[] goods = {
                new Goods("a", 2, 6),
                new Goods("b", 2, 3),
                new Goods("c", 6, 5),
                new Goods("d", 5, 4),
                new Goods("e", 4, 6)
        };
        int[][] bag = new int[goods.length][11];
        int maxValue = 0;
        // f[i,j] = Max{f[i-1,j-Wi]+Pi( j >= Wi ), f[i-1,j] }
        for (int i = 0; i < goods.length; i++) {
            for (int j = 1; j < bag[i].length; j++) {
                if (i == 0) {
                    if (goods[i].getWeight() <= j) {
                        bag[i][j] = goods[i].getValue();
                    }
                } else {
                    bag[i][j] = bag[i - 1][j];
                    if (j < goods[i].getWeight()) {
                        continue;
                    }
                    maxValue = bag[i - 1][j - goods[i].getWeight()] + goods[i].getValue();
                    bag[i][j] = Math.max(maxValue, bag[i - 1][j]);
                }
            }
        }
        for (int i = 0; i < bag.length; i++) {
            System.out.println(Arrays.toString(bag[i]));
        }
    }
}
