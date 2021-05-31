package org.example.linkedlist.doubled;


/**
 * @author castle
 */
public class DoubledLinkedListByOrder {
    private HeroNode head = new HeroNode(0, "");

    public static void main(String[] args) {

        HeroNode liu = new HeroNode(1, "刘备");
        HeroNode guan = new HeroNode(2, "关羽");
        HeroNode zhang = new HeroNode(3, "张飞");

        DoubledLinkedListByOrder doubledLinkedList = new DoubledLinkedListByOrder();
        doubledLinkedList.add(liu);
        doubledLinkedList.add(zhang);
        doubledLinkedList.add(guan);
        doubledLinkedList.show();
        doubledLinkedList.remove(guan);
        doubledLinkedList.show();

    }

    /**
     * 在列表末尾添加
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = this.head;
        while (temp.getNext() != null) {
            if (temp.getNext().getId() < heroNode.getId()) {
                temp = temp.getNext();
            } else {
                temp.getNext().setPrev(heroNode);
                heroNode.setNext(temp.getNext());
                temp.setNext(heroNode);
                heroNode.setPrev(temp);
                break;
            }

        }
        temp.setNext(heroNode);
        heroNode.setPrev(temp);
    }

    /**
     * 验证是否存在某元素
     *
     * @param heroNode
     * @return
     */
    public boolean isHas(HeroNode heroNode) {
        HeroNode temp = this.head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getId() == heroNode.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 移除某节点
     * 自我删除
     *
     * @param heroNode
     */
    public void remove(HeroNode heroNode) {
        if (isHas(heroNode)) {
            heroNode.getNext().setPrev(heroNode.getPrev());
            heroNode.getPrev().setNext(heroNode.getNext());
        } else {
            System.out.println("不存在该元素");
        }
    }

    /**
     * 遍历列表
     */
    public void show() {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp.toString());
        }
    }
}
