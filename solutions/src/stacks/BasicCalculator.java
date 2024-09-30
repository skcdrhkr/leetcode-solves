package stacks;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BasicCalculator.calculate("-2"));

        // Case 2
        System.out.println(BasicCalculator.calculate("12 - (6 + 2) + 5"));

        // Case 3
        System.out.println(BasicCalculator.calculate("(8 + 100) + (13 - 8 - (2 + 1))"));
    }

    public static int calculate(String s) {
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        int num = 0, result = 0;
        stack.push(sign);
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += (c - '0');
            } else if (c == '+' || c == '-') {
                result += (sign * num);
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }
        result += (sign * num);
        return result;
    }
}
