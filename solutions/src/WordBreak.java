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
        if (st.contains(s))
            return true;
        Boolean[] memo = new Boolean[s.length() + 1];
        return breakingWord(s, wordDict, 0, s.length(), memo);
    }

    private static Boolean breakingWord(String s, List<String> wordDict, int i, int length, Boolean[] memo) {
        if (i >= length) {
            return true;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        for (int j = i; j <= length; j++) {
            if (wordDict.contains(s.substring(i, j)) && breakingWord(s, wordDict, j, length, memo)) {
                memo[i] = true;
                return memo[i];
            }
        }
        memo[i] = false;
        return memo[i];
    }
}
