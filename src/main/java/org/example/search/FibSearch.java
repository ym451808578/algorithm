package org.example.search;

import java.util.Arrays;

/**
 * @author castle
 */
public class FibSearch {

    private int[] arr;

    public FibSearch(int[] arr) {
        this.arr = arr;
    }

    public int[] fib(int size) {
        int[] fib = new int[size];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < size; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public int search(int data) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int index = 0;
        //当数组长度为2时，不行
        int[] f = fib(arr.length);
        while (right > f[index] - 1) {
            index++;
        }
        int[] temp = Arrays.copyOf(arr, f[index]);
        for (int i = right + 1; i < temp.length - 1; i++) {
            temp[i] = temp[right];
        }
        while (left < right) {
            mid = left + f[index - 1] - 1;
            if (data < arr[mid]) {
                right = mid - 1;
                index--;
            } else if (data > arr[mid]) {
                left = mid + 1;
                index--;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
