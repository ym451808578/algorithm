package org.example.search;

/**
 * @author Castle
 * @Date 2021/6/9 15:29
 */
public class BinarySearchWithoutRecursion {
    private int[] arr;

    public BinarySearchWithoutRecursion(int[] arr) {
        this.arr = arr;
    }

    public int search(int data) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (arr[midIndex] == data) {
                return midIndex;
            } else if (arr[midIndex] < data) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
