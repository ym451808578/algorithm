package org.example.stack;

/**
 * @author castle
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        String expression = "15+20-3*5+10/2";
        ArrayStack numberStack = new ArrayStack(10);
        ArrayStack operaStack = new ArrayStack(10);
        int left = 0;
        int right = 0;
        int tempRes = 0;
        String mulNum = "";
        char[] arr = expression.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (isOpera(arr[i])) {
                if (!operaStack.isEmpty()) {
                    int peekOpera = operaStack.peek();
                    while (!operaStack.isEmpty() && getPriority(peekOpera) >= getPriority(arr[i])) {
                        right = numberStack.pop();
                        left = numberStack.pop();
                        peekOpera = operaStack.pop();
                        tempRes = calculate(left, right, peekOpera);
                        numberStack.push(tempRes);
                    }
                }
                operaStack.push(arr[i]);
            } else {
                mulNum += arr[i];
                if (i == arr.length - 1 || isOpera(arr[i + 1])) {
                    numberStack.push(Integer.parseInt(mulNum));
                    mulNum = "";
                }
            }
        }

        numberStack.show();
        operaStack.show();

        while (!operaStack.isEmpty()) {
            right = numberStack.pop();
            System.out.println("right:" + right);
            left = numberStack.pop();
            System.out.println("left:" + left);
            tempRes = calculate(left, right, operaStack.pop());
            numberStack.push(tempRes);
        }
        System.out.println(numberStack.peek());

    }

    public static int getPriority(int val) {
        if (val == '*' || val == '/') {
            return 1;
        } else if (val == '+' || val == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    private static boolean isOpera(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    private static int calculate(int left, int right, int opera) {
        switch (opera) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            default:
                throw new RuntimeException("请检查运算符");
        }
    }
}
