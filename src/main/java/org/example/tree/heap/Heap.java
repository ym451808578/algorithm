package org.example.tree.heap;

import java.util.Arrays;

/**
 * @author Castle
 * @Date 2021/6/3 9:16
 */
public class Heap {

    private int[] arr;

    public Heap(int[] arr) {
        this.arr = arr;
    }

    public void heapSort() {
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //System.out.println(Arrays.toString(arr));

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }
        //System.out.println(Arrays.toString(arr));
    }

    public void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int lChild = parent * 2 + 1;
        while (lChild < length) {
            int rChild = lChild + 1;
            //如果左子节点小于右子节点，则取右子节点的值
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            if (temp > arr[lChild]) {
                break;
            }
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = lChild * 2 + 1;
        }
        arr[parent] = temp;
    }
}
