package org.example.search;

/**
 * @author castle
 */
public class InsertValueSearch {
    private int[] arr;

    public InsertValueSearch(int[] arr) {
        this.arr = arr;
    }

    public int search(int left, int right, int data) {
        while (left < right) {
            System.out.println("Insert Value Search");
            int mid = left + (right - left) * (data - arr[left]) / (arr[right] - arr[left]);
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
