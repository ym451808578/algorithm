package org.example.stack;

/**
 * 用数组模拟一个栈
 *
 * @author castle
 */
public class ArrayStack {

    private int[] arr;
    /**
     * 容量
     */
    private int size;
    /**
     * 栈顶
     */
    private int top;


    /**
     * 初始化一个栈
     *
     * @param size
     */
    public ArrayStack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        //arrayStack.pop();
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param
     */
    public void push(int t) {
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        arr[top] = t;
    }

    /**
     * 出栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        int t = arr[top];
        top--;
        return t;
    }

    /**
     * 查看栈顶
     *
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        return arr[top];
    }

    public void show() {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
