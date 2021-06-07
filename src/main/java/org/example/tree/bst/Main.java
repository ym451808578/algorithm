package org.example.tree.bst;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Castle
 * @Date 2021/6/7 16:49
 */
public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[8];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new Random().nextInt(100);
//        }
        int[] arr = {65, 46, 50, 51, 1, 96, 76, 85};
        System.out.println(Arrays.toString(arr));
        BinarySortTree binarySortTree = new BinarySortTree(arr);
        Node root = binarySortTree.createTree(arr);
        binarySortTree.infixOrder(root);
        System.out.println("**************");
        System.out.println(root);
        Node node = binarySortTree.search(root, arr[2]);
        System.out.println(node);
        Node parent = binarySortTree.searchParent(root, arr[2]);
        System.out.println(parent);
        System.out.println("************");
//        binarySortTree.deleteNode(root,85);
//        binarySortTree.deleteNode(root,76);
        binarySortTree.deleteNode(root,76);
        binarySortTree.infixOrder(root);
    }
}
