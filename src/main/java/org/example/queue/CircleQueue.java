package org.example.queue;

/**
 * 使用数组模拟环形队列，环形队列默认空一个位置
 *
 * @author castle
 */
public class CircleQueue {
    private int size;
    private int[] arr;
    private int head;
    private int tail;

    public CircleQueue(int size) {
        this.size = size + 1;
        arr = new int[this.size];
        head = 0;
        tail = 0;
    }

    public static void main(String[] args) {
        CircleQueue arrayQueue = new CircleQueue(5);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.addElement(1);
        arrayQueue.addElement(3);
        System.out.println(arrayQueue.touchHead());
        arrayQueue.addElement(5);
        arrayQueue.addElement(7);
        arrayQueue.addElement(9);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());
        arrayQueue.show();
        System.out.println(arrayQueue.touchHead());
        for (int i = 0; i < arrayQueue.size - 1; i++) {
            System.out.println(arrayQueue.getElement());
        }
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.addElement(11);
        System.out.println(arrayQueue.touchHead());
        arrayQueue.addElement(12);
        arrayQueue.addElement(13);
        arrayQueue.getElement();
        System.out.println(arrayQueue.touchHead());
    }

    /**
     * 判断是否满
     *
     * @return
     */
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    /**
     * 判断是否空
     *
     * @return
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 添加元素
     *
     * @param i
     */
    public void addElement(int i) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        arr[tail] = i;
        tail = (tail + 1) % size;
    }

    /**
     * 获取元素
     *
     * @return
     */
    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        int value = arr[head];
        head = (head + 1) % size;
        return value;
    }

    /**
     * 查看头部元素，不出队列
     *
     * @return
     */
    public int touchHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空");
        }
        return arr[head];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = head; i < head + size - 1; i++) {
            System.out.print(arr[i % size] + " ");
        }
        System.out.println();
    }
}
