package stacks;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {

        // Case 0
        System.out.println(DecodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(DecodeString.decodeString("m3[k]"));
        System.out.println(DecodeString.decodeString("3[m]d2[k]"));
        System.out.println(DecodeString.decodeString("3[a2[b]2[c]]"));

        // Case 1
        System.out.println(DecodeString.decodeString("3[a]2[bc]"));

        // Case 2
        System.out.println(DecodeString.decodeString("3[a2[bc]]"));

        // Case 3
        System.out.println(DecodeString.decodeString("3[ab2[c2[md]]]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        StringBuilder current = new StringBuilder();
        int times = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                times = times * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(times);
                times = 0;
                strings.push(current);
                current = new StringBuilder();
            } else if (c == ']') {
                int count = counts.pop();
                StringBuilder prev = strings.pop();
                while (count > 0) {
                    prev.append(current);
                    count--;
                }
                current = prev;
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
