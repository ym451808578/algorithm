package org.example.tree.base;

/**
 * @author Castle
 * @Date 2021/6/1 17:48
 */
public class Main {
    public static void main(String[] args) {
        PersonNode personNode1 = new PersonNode(1, "刘备");
        PersonNode personNode2 = new PersonNode(2, "关羽");
        PersonNode personNode3 = new PersonNode(3, "张飞");
        PersonNode personNode4 = new PersonNode(4, "诸葛亮");
        PersonNode personNode5 = new PersonNode(5, "赵云");

        personNode1.setLeft(personNode2);
        personNode1.setRight(personNode3);
        personNode2.setLeft(personNode4);
        personNode2.setRight(personNode5);

        BinaryTree binaryTree = new BinaryTree(personNode1);
        binaryTree.preOrderList();
        System.out.println("******");
        binaryTree.idxOrderList();
        System.out.println("******");
        binaryTree.postOrderList();
    }
}
