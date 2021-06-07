package org.example.sort;

/**
 * @author Castle
 * @Date 2021/6/4 10:35
 */
public class InsertSort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }
}
