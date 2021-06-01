package org.example.stack;

import java.util.Arrays;
import java.util.List;

/**
 * @author castle
 */
public class PolandNotationCalculator {

    public static void main(String[] args) {
        String expression = "4 5 * 8 - 60 + 8 2 / +";

        List<String> strings = getListString(expression);

        calculate(strings);


    }

    private static List<String> getListString(String expression) {
        String[] strings = expression.split(" ");
        return Arrays.asList(strings);
    }

    private static void calculate(List<String> strings) {
        ArrayStack numberStack = new ArrayStack(10);
        int left = 0;
        int right = 0;
        for (String s : strings) {
            if (isNum(s)) {
                numberStack.push(Integer.parseInt(s));
            } else {
                right = numberStack.pop();
                left = numberStack.pop();
                if ("+".equals(s)) {
                    numberStack.push(left + right);
                }
                if ("-".equals(s)) {
                    numberStack.push(left - right);
                }
                if ("*".equals(s)) {
                    numberStack.push(left * right);
                }
                if ("/".equals(s)) {
                    numberStack.push(left / right);
                }
            }

        }
        System.out.println("计算结果是：" + numberStack.peek());
    }

    private static boolean isNum(String s) {
        return s.matches("\\d+");
    }
}
