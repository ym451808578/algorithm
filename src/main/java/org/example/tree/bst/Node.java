package org.example.tree.bst;

import lombok.Data;
import lombok.ToString;

/**
 * @author Castle
 * @Date 2021/6/7 16:05
 */
@Data
@ToString(exclude = {"left", "right"})
public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }
}
