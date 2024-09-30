package stacks;

import java.util.Stack;

/**
 * Problem URL: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 * Level: Medium
 */

public class MinRemoveMakeValidParenthesis {

    public static void main(String[] args) {

        // Case 0
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("())()((("));

        // Case 1
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("lee(t(c)o)de)"));
        // Case 2
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("a)b(c)d"));
        // Case 3
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("))(("));

        // Case 4
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("((()()("));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] expression = s.toCharArray();
        int len = expression.length;
        int open = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = expression[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    expression[i] = '-';
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            expression[stack.pop()] = '-';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : expression) {
            if (c != '-') sb.append(c);
        }
        return sb.toString();
    }
}
