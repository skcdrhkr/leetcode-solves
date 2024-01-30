import java.util.Stack;

/**
 * Problem URL: https://leetcode.com/problems/evaluate-reverse-polish-notation/description
 * Level: Medium
 */


public class ReversePolishNotation {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));

        // Case 2
        System.out.println(ReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));

        // Case 3
        System.out.println(ReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int res = 0, first, second;
        String cur;
        for (String token : tokens) {
            cur = token;
            if (cur.equals("+")) {
                first = st.pop();
                second = st.pop();
                st.push(first + second);
            } else if (cur.equals("-")) {
                first = st.pop();
                second = st.pop();
                st.push(second - first);
            } else if (cur.equals("*")) {
                first = st.pop();
                second = st.pop();
                st.push(first * second);
            } else if (cur.equals("/")) {
                first = st.pop();
                second = st.pop();
                st.push(second / first);
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
