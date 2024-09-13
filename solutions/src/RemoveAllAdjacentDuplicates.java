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

        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && c == st.peek()) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }
}
