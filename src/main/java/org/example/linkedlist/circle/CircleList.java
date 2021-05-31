package org.example.linkedlist.circle;

/**
 * @author castle
 */
public class CircleList {
    private Child first = new Child(1);

    public static void main(String[] args) {
        CircleList circleList = new CircleList();
        circleList.remove(2, 3, 5);
    }

    public void create(int n) {
        Child current = null;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                first.setNext(first);
                current = first;
            } else {
                Child child = new Child(i);
                current.setNext(child);
                child.setNext(first);
                current = child;
            }
        }
    }

    public void show() {
        Child temp = first;
        System.out.println(temp);
        while (temp.getNext() != first) {
            temp = temp.getNext();
            System.out.println(temp);
        }
    }

    public void remove(int startNum, int step, int count) {
        create(count);
        Child flag = first;
        while (flag.getNext() != first) {
            //将flag放到最后一个位置
            flag = flag.getNext();
        }
        //将first和flag分别移到startNum点和前一个位置
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            flag = flag.getNext();
        }
        int loop=0;
        while (loop<count){
            //走step步数
            for (int i = 0; i < step - 1; i++) {
                first = first.getNext();
                flag = flag.getNext();
            }
            //把当前节点取出
            flag.setNext(first.getNext());
            System.out.println("取出的节点：" + first);
            first=first.getNext();
            loop++;

        }

    }
}
