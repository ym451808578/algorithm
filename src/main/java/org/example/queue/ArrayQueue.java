package org.example.queue;

/**
 * 使用数组模拟简单队列
 *
 * @author castle
 */
public class ArrayQueue {
    private int size;
    private int[] arr;
    private int head;
    private int tail;

    public ArrayQueue(int size) {
        this.size = size;
        arr = new int[size];
        head = -1;
        tail = -1;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
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
        for (int i = 0; i < arrayQueue.size; i++) {
            System.out.println(arrayQueue.getElement());
        }
        System.out.println(arrayQueue.isEmpty());
        //抛出ArrayIndexOutOfBoundsException,
        arrayQueue.addElement(11);
    }

    /**
     * 判断是否满
     *
     * @return
     */
    public boolean isFull() {
        return tail == size - 1;
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
        tail++;
        arr[tail] = i;
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
        head++;
        return arr[head];
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
        return arr[head + 1];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
