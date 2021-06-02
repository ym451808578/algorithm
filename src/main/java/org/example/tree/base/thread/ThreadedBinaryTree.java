package org.example.tree.base.thread;

/**
 * @author Castle
 * @Date 2021/6/2 16:39
 */
public class ThreadedBinaryTree {
    private PersonNode root;

    private PersonNode pre = null;

    public ThreadedBinaryTree(PersonNode root) {
        this.root = root;
    }

    public void infixThreaded() {
        infixThreaded(this.root);
    }

    private void infixThreaded(PersonNode node) {
        if (node == null) {
            return;
        }
        //左
        infixThreaded(node.getLeft());
        //中
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        //右
        infixThreaded(node.getRight());

    }

    public void infixOrderList() {
        PersonNode node = root;
        if (root == null) {
            return;
        }
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}
