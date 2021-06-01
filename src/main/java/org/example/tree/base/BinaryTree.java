package org.example.tree.base;

/**
 * @author Castle
 * @Date 2021/6/1 16:38
 */
public class BinaryTree {
    private PersonNode root;

    public BinaryTree(PersonNode root) {
        this.root = root;
    }

    /**
     * 前序遍历：
     * 1.输出当前节点；
     * 2.递归前序遍历左子节点（若不为空）
     * 3.递归前序遍历右子节点（若不为空）
     */
    public void preOrderList() {
        preOrderList(this.root);
    }

    private void preOrderList(PersonNode personNode) {
        System.out.println(personNode);
        if (personNode.getLeft() != null) {
            preOrderList(personNode.getLeft());
        }
        if (personNode.getRight() != null) {
            preOrderList(personNode.getRight());
        }
    }

    /**
     * 中序遍历：
     * 1.递归前序遍历左子节点（若不为空）
     * 2.输出当前节点；
     * 3.递归前序遍历右子节点（若不为空）
     */
    public void idxOrderList() {
        idxOrderList(this.root);
    }

    private void idxOrderList(PersonNode personNode) {
        if (personNode.getLeft() != null) {
            idxOrderList(personNode.getLeft());
        }
        System.out.println(personNode);

        if (personNode.getRight() != null) {
            idxOrderList(personNode.getRight());
        }
    }

    /**
     * 后序遍历：
     * 1.递归前序遍历左子节点（若不为空）
     * 2.递归前序遍历右子节点（若不为空）
     * 3.输出当前节点；
     */
    public void postOrderList() {
        postOrderList(this.root);
    }

    private void postOrderList(PersonNode personNode) {
        if (personNode.getLeft() != null) {
            postOrderList(personNode.getLeft());
        }
        if (personNode.getRight() != null) {
            postOrderList(personNode.getRight());
        }
        System.out.println(personNode);
    }
}
