package org.example.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author castle
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arr);
//        SelectSort selectSort = new SelectSort();
//        selectSort.sort(arr);
//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(arr);
//        ShellSort shellSort=new ShellSort();
//        shellSort.sort(arr);
//        QuickSort quickSort = new QuickSort();
//        quickSort.sort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(arr, 0, arr.length - 1, new int[arr.length]);
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
