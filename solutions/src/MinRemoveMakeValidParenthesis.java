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

        // Case 4
        System.out.println(MinRemoveMakeValidParenthesis.minRemoveToMakeValid("((()()("));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int open = 0;
        for (int i = 0; i < len; i++) {
            if (cs[i] == '(') {
                open++;
            } else if (cs[i] == ')') {
                if (open != 0) open--;
                else cs[i] = '-';
            }
        }
        for (int i = len - 1; i >= 0 && open > 0; i--) {
            if (cs[i] == '(') {
                cs[i] = '-';
                open--;
            }
        }
        int ind = 0;
        for (int i = 0; i < len; i++) {
            if (cs[i] != '-') cs[ind++] = cs[i];
        }
        return new String(cs).substring(0, ind);
    }
}
