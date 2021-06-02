package org.example.tree.base.thread;

/**
 * @author Castle
 * @Date 2021/6/2 17:11
 */
public class Main {
    public static void main(String[] args) {
        PersonNode personNode1=new PersonNode(1,"刘备");
        PersonNode personNode2=new PersonNode(2,"关羽");
        PersonNode personNode3=new PersonNode(3,"张飞");
        PersonNode personNode4=new PersonNode(4,"诸葛亮");
        PersonNode personNode5=new PersonNode(5,"赵云");
        PersonNode personNode6=new PersonNode(6,"黄忠");
        personNode1.setLeft(personNode2);
        personNode1.setRight(personNode3);
        personNode2.setLeft(personNode4);
        personNode2.setRight(personNode5);
        personNode3.setLeft(personNode6);
        ThreadedBinaryTree binaryTree=new ThreadedBinaryTree(personNode1);
        binaryTree.infixThreaded();
//        System.out.println(personNode4.getRight());
//        System.out.println(personNode5.getLeft());
//        System.out.println(personNode5.getRight());
//        System.out.println(personNode6.getLeft());
//        System.out.println(personNode6.getRight());
//        System.out.println(personNode3.getLeft());
        binaryTree.infixOrderList();
    }
}
