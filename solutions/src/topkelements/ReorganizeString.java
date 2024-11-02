package topkelements;

import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReorganizeString.reorganizeString("aab"));

        // Case 2
        System.out.println(ReorganizeString.reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        char[] freq = new char[26];
        int mxFreq = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > mxFreq) {
                mxFreq = freq[c - 'a'];
            }
        }
        if (mxFreq > (s.length() + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((x, y) -> freq[y - 'a'] - freq[x - 'a']);
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                heap.add((char) (i + 'a'));
            }
        }
        StringBuilder result = new StringBuilder();
        int ind = 0;
        while (ind < s.length()) {
            if (result.isEmpty() || result.charAt(result.length() - 1) != heap.peek()) {
                char top = heap.peek();
                result.append(top);
                freq[top - 'a'] -= 1;
            } else {
                char top = heap.poll();
                char secondTop = heap.peek();
                result.append(secondTop);
                freq[secondTop - 'a'] -= 1;
                heap.add(top);
            }
            ind += 1;
        }
        return result.toString();
    }
}
