public class ValidParenthesisString {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ValidParenthesisString.checkValidString("()"));

        // Case 2
        System.out.println(ValidParenthesisString.checkValidString("(*)"));

        // Case 3
        System.out.println(ValidParenthesisString.checkValidString("(*))"));

        // Case 4
        System.out.println(ValidParenthesisString.checkValidString("((*)(*"));

        // Case 5
        System.out.println(ValidParenthesisString.checkValidString("((*)))"));

        // Case 6
        System.out.println(ValidParenthesisString.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    public static boolean checkValidString(String s) {
        char[] paren = s.toCharArray();
        int len = paren.length;
        int[] closed = new int[len];
        int closeCount = 0;
        char c;
        for (int i = len - 1; i >= 0; i--) {
            if (paren[i] == ')') closeCount++;
            else if (paren[i] == '(') closeCount--;
            if (closeCount < 0) closeCount = 0;
            closed[i] = closeCount;
        }
        int openCount = 0;
        for (int i = 0; i < len; i++) {
            c = paren[i];
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                openCount--;
            }
            if (openCount < 0)
                return false;
            if (c == '*') {
                if (closed[i] > openCount) openCount++;
                else if (closed[i] < openCount) openCount--;
            }
        }
        return openCount == 0;
    }
}
