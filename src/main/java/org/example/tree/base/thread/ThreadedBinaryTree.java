package org.example.tree.base.thread;

/**
 * @author Castle
 * @Date 2021/6/2 16:39
 */
public class ThreadedBinaryTree {
    private PersonNode root;

    public ThreadedBinaryTree(PersonNode root) {
        this.root = root;
    }

    public void threaded() {

    }

    public void preOrderList() {
        PersonNode node = root;
        if (root == null) {
            return;
        }
        while (node != null) {
            System.out.println(node);
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }

    }
}
