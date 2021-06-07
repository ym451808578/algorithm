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

    /**
     * 以当前节点为根节点的树的高度
     *
     * @return
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 左子树的高度
     *
     * @return
     */
    public int leftHeight() {
        return left.height();
    }

    /**
     * 右子树的高度
     *
     * @return
     */
    public int rightHeight() {
        return right.height();
    }
}
