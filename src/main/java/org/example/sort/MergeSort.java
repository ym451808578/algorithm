package org.example.sort;

/**
 * @author Castle
 * @Date 2021/6/7 10:02
 */
public class MergeSort {

    public void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                index += 1;
                i += 1;
            } else {
                temp[index] = arr[j];
                index += 1;
                j += 1;
            }
        }
        while (i <= mid) {
            temp[index] = arr[i];
            index += 1;
            i += 1;
        }

        while (j <= right) {
            temp[index] = arr[j];
            index += 1;
            j += 1;
        }

        index = 0;
        int tempIndex = left;
        while (tempIndex <= right) {
            arr[tempIndex] = temp[index];
            index += 1;
            tempIndex += 1;

        }
    }
}
