package org.example.tree.base;

/**
 * 顺序二叉树通常只考虑完全二叉树
 * 第n个元素的左子节点为2n+1
 * 第n个元素的右子节点为2n+2
 * 第n个元素的父节点为(n-1)/2
 *
 * @author Castle
 * @Date 2021/6/2 14:39
 */
public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrderList() {
        preOrderList(0);
    }

    /**
     * 前序遍历
     *
     * @param index
     */
    private void preOrderList(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        if (index * 2 + 1 < arr.length) {
            preOrderList(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            preOrderList(index * 2 + 2);
        }

    }
}
