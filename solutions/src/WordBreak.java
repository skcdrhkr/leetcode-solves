/**
 * Problem URL: https://leetcode.com/problems/word-break/description
 * Level: Medium
 */

import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        // Case 1
        System.out.println(WordBreak.wordBreak("leetcode", List.of("leet", "code")));

        // Case 2
        System.out.println(WordBreak.wordBreak("applepenapple", List.of("apple", "pen")));

        // Case 3
        System.out.println(WordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));

        // Case 4
        System.out.println(WordBreak.wordBreak("abcd", List.of("a", "abc", "b", "cd")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> st = new HashSet<>(wordDict);
        int n = s.length();
        if (st.contains(s))
            return true;
        byte[] dp = new byte[n + 1];
        return breaking(s.getBytes(), st, 0, n, dp) == 2;
    }

    private static byte breaking(byte[] s, HashSet<String> st, int i, int n, byte[] dp) {
        if (i >= n)
            return 2;
        byte cur = 1;
        if (dp[i] != 0) {
            return dp[i];
        }
        for (int k = i; k < n; k++) {
            if (st.contains(new String(s, i, k - i + 1))) {
                cur = breaking(s, st, k + 1, n, dp);
            }
            if (cur == 2)
                break;
        }
        dp[i] = cur;
        return cur;
    }
}
