package org.example.tree.base;

/**
 * @author Castle
 * @Date 2021/6/2 16:01
 */
public class ArrBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrderList();
    }
}
