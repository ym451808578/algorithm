package org.example.search;

/**
 * @author castle
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        BaseSearch baseSearch = new BaseSearch(arr);
        System.out.println(baseSearch.search(1000));
        BinarySearch binarySearch = new BinarySearch(arr);
        System.out.println(binarySearch.search(0, arr.length - 1, 1000));
        InsertValueSearch insertValueSearch = new InsertValueSearch(arr);
        System.out.println(insertValueSearch.search(0, arr.length - 1, 1000));
        FibSearch fibSearch=new FibSearch(arr);
        System.out.println(fibSearch.search(8));
    }
}
