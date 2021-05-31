package org.example.search;

/**
 * @author castle
 */
public class BinarySearch {
    private int[] arr;

    public BinarySearch(int[] arr) {
        this.arr = arr;
    }

    public int search(int left, int right, int data) {
        while (left < right) {
            System.out.println("Binary Search");
            int mid = (left + right) / 2;
            if (arr[mid] > data) {
                return search(left, mid - 1, data);
            } else if (arr[mid] < data) {
                return search(mid + 1, right, data);
            } else if (arr[mid] == data) {
                return mid;
            }
        }
        return -1;
    }
}
