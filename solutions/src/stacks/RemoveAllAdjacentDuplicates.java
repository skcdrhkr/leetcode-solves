package stacks;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {
        // Case 1
        System.out.println(RemoveAllAdjacentDuplicates.removeDuplicates("abbaca"));

        // Case 2
        System.out.println(RemoveAllAdjacentDuplicates.removeDuplicates("azxxzy"));

        // Case 3
        System.out.println(RemoveAllAdjacentDuplicates.removeDuplicates("aabbccdd"));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else {
                char top = stack.peek();
                if (top == c) stack.pop();
                else stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
