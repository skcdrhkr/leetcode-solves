import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ReorganizeString.reorganizeString("aab"));

        // Case 2
        System.out.println(ReorganizeString.reorganizeString("aaab"));
    }

    public static String reorganizeString(String s) {
        int len = s.length();
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (freq[y] - freq[x]));
        for (char c : s.toCharArray()) {
            freq[c - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                pq.add(i);
            }
        }
        StringBuilder result = new StringBuilder();
        while (result.length() < len) {
            int top = pq.peek() + 'a';
            if (!result.isEmpty() && result.charAt(result.length() - 1) == (char) top) {
                if (pq.size() == 1) return "";
                top = pq.poll();
                result.append((char) ('a' + pq.peek().intValue()));
                freq[pq.peek()] -= 1;
                if (freq[pq.peek()] == 0) pq.poll();
                pq.add(top);
            } else {
                result.append((char) ('a' + pq.peek().intValue()));
                freq[pq.peek()] -= 1;
                if (freq[pq.peek()] == 0) pq.poll();
            }
        }
        return result.toString();
    }
}
