import java.util.Stack;

/**
 * Problem URL: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 * Level: Medium
 */

public class MinRemoveMakeValidParenthesis {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("lee(t(c)o)de)"));
        // Case 2
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("a)b(c)d"));
        // Case 3
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] cs = s.toCharArray();
        char cur;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            cur = cs[i];
            if (cur != ')' && cur != '(')
                continue;
            if (cur == ')') {
                if (!st.isEmpty() && st.peek() < 0) {
                    st.pop();
                } else {
                    st.push(i + 1);
                }
            } else {
                st.push(-1 * (i + 1));
            }
        }
        int ind = cs.length - 1;
        int top;
        if (st.isEmpty())
            return s;
        for (int k = cs.length - 1; k >= 0; k--) {
            if ((cs[k] != ')' && cs[k] != '(') || (st.isEmpty())) {
                cs[ind--] = cs[k];
                continue;
            }
            top = st.peek() > 0 ? st.peek() - 1 : (-1 * st.peek()) - 1;
            if (k != top) {
                cs[ind--] = cs[k];
            } else {
                st.pop();
            }
        }
        return new String(cs, ind + 1, cs.length - ind - 1);
    }
}
