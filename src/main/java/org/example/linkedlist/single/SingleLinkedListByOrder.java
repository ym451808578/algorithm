package org.example.linkedlist.single;

/**
 * @author castle
 */
public class SingleLinkedListByOrder {
    private HeroNode head = new HeroNode(0, "");

    public static void main(String[] args) {
        HeroNode liu = new HeroNode(1, "刘备");
        HeroNode guan = new HeroNode(2, "关羽");
        HeroNode yu = new HeroNode(2, "关羽");
        HeroNode zhang = new HeroNode(3, "张飞");
        HeroNode zhao = new HeroNode(4, "赵云");

        SingleLinkedListByOrder singleLinkedList = new SingleLinkedListByOrder();
        singleLinkedList.add(liu);
        singleLinkedList.add(zhao);
        singleLinkedList.add(guan);
        singleLinkedList.add(zhang);
        singleLinkedList.show();
        System.out.println(singleLinkedList.isHas(guan));
        singleLinkedList.remove(guan);
        singleLinkedList.show();
    }

    /**
     * 在列表末尾添加
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        if (isHas(heroNode)) {
            System.out.println("已经存在" + heroNode);
            return;
        }
        HeroNode temp = this.head;
        while (temp.getNext() != null) {
            if (temp.getNext().getId() < heroNode.getId()) {
                temp = temp.getNext();
            } else {
                heroNode.setNext(temp.getNext());
                temp.setNext(heroNode);
                break;
            }
        }
        temp.setNext(heroNode);
    }

    /**
     * 验证是否存在某元素
     *
     * @param heroNode
     * @return
     */
    public boolean isHas(HeroNode heroNode) {
        HeroNode temp = head;
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
     *
     * @param heroNode
     */
    public void remove(HeroNode heroNode) {
        HeroNode temp = this.head;
        if (isHas(heroNode)) {
            while (temp.getNext() != null) {
                if (temp.getNext().getId() == heroNode.getId()) {
                    temp.setNext(heroNode.getNext());
                    heroNode.setId(-1);
                    System.out.println("移除成功");
                } else {
                    temp = temp.getNext();
                }
            }
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
