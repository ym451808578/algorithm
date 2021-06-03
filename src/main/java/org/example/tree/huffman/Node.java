package org.example.tree.huffman;

import lombok.Data;
import lombok.ToString;

/**
 * @author Castle
 * @Date 2021/6/3 15:31
 */
@Data
@ToString(exclude = {"left", "right"})
public class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }
}
