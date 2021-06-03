package org.example.recursion;

import java.util.Arrays;

/**
 * @author Castle
 * @Date 2021/6/3 11:48
 */
public class Queen {
    private static int max = 8;
    private static int[] cheese = new int[max];

    private static int count = 0;

    public static void main(String[] args) {
        put(0);
        System.out.println(count);
    }

    public static void put(int n) {

        if (n == max) {
            count++;
            System.out.println(Arrays.toString(cheese));
            return;
        }
        for (int i = 0; i < max; i++) {
            cheese[n] = i;
            if (isClash(n)) {
                put(n + 1);
            }
        }
    }

    public static boolean isClash(int n) {
        for (int i = 0; i < n; i++) {
            if (cheese[i] == cheese[n] || (n - i) == Math.abs(cheese[n] - cheese[i])) {
                return false;
            }
        }
        return true;
    }
}
