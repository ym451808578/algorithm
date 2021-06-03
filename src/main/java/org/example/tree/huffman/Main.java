package org.example.tree.huffman;

/**
 * @author Castle
 * @Date 2021/6/3 17:32
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanTree huffmanTree = new HuffmanTree(arr);
        Node root = huffmanTree.createTree();
        huffmanTree.preOrderList(root);
    }
}
