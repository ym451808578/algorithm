package org.example.search;

/**
 * @author castle
 */
public class BaseSearch {
    private int[] arr;

    public BaseSearch(int[] arr) {
        this.arr = arr;
    }

    public int search(int data) {
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

}
