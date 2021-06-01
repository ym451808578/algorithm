package org.example.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author castle
 */
public class ParseToSuffixNotation {

    public static void main(String[] args) {
        String expression = "1+((20+3)*4)-5";
        parse(expression);
    }

    private static void parse(String expression) {
        List<String> listString = getListString(expression);
        //存储运算符
        Stack<String> stringStack = new Stack<>();
        //存储结果
        List<String> resultString = new ArrayList<>();
        for (String s : listString) {
            //如果是数字，直接放入结果list
            if (s.matches("\\d+")) {
                resultString.add(s);
            } else if ("(".equals(s)) {
                stringStack.push(s);
            } else if (")".equals(s)) {
                while (true) {
                    String s1 = stringStack.pop();
                    if (s1.equals("(")) {
                        break;
                    } else {
                        resultString.add(s1);
                    }
                }

            } else {
                while (true) {
                    if (stringStack.isEmpty() || getPriority(s) > getPriority(stringStack.peek())) {
                        stringStack.push(s);
                        break;
                    } else {
                        resultString.add(stringStack.pop());
                    }
                }
            }

        }
        for (String s1 : stringStack) {
            resultString.add(s1);
        }
        System.out.println(resultString);

    }

    private static List<String> getListString(String expression) {
        char[] chars = expression.toCharArray();
        List<String> list = new ArrayList<>(chars.length);
        String mulNum = "";
        for (int i = 0; i < chars.length; i++) {
            // 0-48,9-57
            if (chars[i] < 48 || chars[i] > 57) {
                list.add(chars[i] + "");
            } else {
                mulNum += chars[i];
                if (i == chars.length - 1 || chars[i + 1] < 48 | chars[i + 1] > 57) {
                    list.add(mulNum);
                    mulNum = "";
                }
            }
        }
        System.out.println(list.toString());
        return list;
    }

    private static int getPriority(String s) {
        switch (s) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }
}
