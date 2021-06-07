package org.example.sort;

/**
 * @author Castle
 * @Date 2021/6/7 14:26
 */
public class RadixSort {
    public void sort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();
        int[][] basket = new int[10][arr.length];
        int[] basketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int valOfElement = arr[j] / n % 10;
                basket[valOfElement][basketElementCounts[valOfElement]] = arr[j];
                basketElementCounts[valOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < basketElementCounts.length; k++) {
                if (basketElementCounts[k] != 0) {
                    for (int l = 0; l < basketElementCounts[k]; l++) {
                        arr[index++] = basket[k][l];
                    }
                }
                basketElementCounts[k] = 0;
            }
        }
    }
}
