package org.example.tree.huffman.code;

import lombok.Data;
import lombok.ToString;

/**
 * @author castle
 */
@Data
@ToString(exclude = {"left", "right"})
public class Node implements Comparable<Node> {
    /**
     * 数据
     */
    private Byte data;
    /**
     * 出现的次数
     */
    private int weight;
    private Node left;
    private Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;
    }

}
