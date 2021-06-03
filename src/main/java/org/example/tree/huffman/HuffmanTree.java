package org.example.tree.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Castle
 * @Date 2021/6/3 15:38
 */
public class HuffmanTree {
    private int[] arr;

    public HuffmanTree(int[] arr) {
        this.arr = arr;
    }

    public Node createTree() {
        List<Node> nodeList = new ArrayList<>();
        for (int val : arr) {
            nodeList.add(new Node(val));
        }
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);
            Node tempParent = new Node(leftNode.getValue() + rightNode.getValue());
            tempParent.setLeft(leftNode);
            tempParent.setRight(rightNode);
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(tempParent);
        }
        System.out.println(nodeList.get(0));
        return nodeList.get(0);
    }

    public void preOrderList(Node node) {
        System.out.println(node);
        if (node.getLeft() != null) {
            preOrderList(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrderList(node.getRight());
        }
    }
}
