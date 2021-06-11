package org.example.dac;

/**
 * @author Castle
 * @Date 2021/6/9 16:32
 */
public class Main {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.tower(10, "A", "B", "C");
    }
}
