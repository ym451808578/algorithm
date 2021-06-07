package org.example.sort;

import java.awt.*;

/**
 * @author Castle
 * @Date 2021/6/4 10:58
 */
public class ShellSort {
    public void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[i]) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
    }
}
