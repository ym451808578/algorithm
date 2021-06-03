package org.example.tree.heap;

import java.awt.*;
import java.util.Random;

/**
 * @author Castle
 * @Date 2021/6/3 9:40
 */
public class Main {
    public static void main(String[] args) {
        //int[] arr={4,6,8,5,9};
        //int[] arr = {16, 7, 3, 20, 17, 8};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = new Random().nextInt(80000);
        }
        Heap heap = new Heap(arr);
        Long time1=System.currentTimeMillis();
        heap.heapSort();
        Long time2=System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}
