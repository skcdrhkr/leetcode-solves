/**
 * Problem URL: https://leetcode.com/problems/word-break/description
 * Level: Medium
 */

package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        // Case 1
        System.out.println(WordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

        // Case 2
        System.out.println(WordBreak.wordBreak("applepenapple", List.of("apple", "pen")));

        // Case 3
        System.out.println(WordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));

        // Case 4
        System.out.println(WordBreak.wordBreak("abcd", List.of("a", "abc", "b", "cd")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        if (dict.contains(s)) return true;
        int len = s.length();
        int[] memo = new int[len + 1];
        Arrays.fill(memo, -1);
        return isWordBreakPossible(s, dict, 0, memo);
    }

    private static boolean isWordBreakPossible(String s, HashSet<String> dict, int index, int[] memo) {
        if (index == s.length()) return true;
        if (memo[index] != -1) return memo[index] == 1;
        for (int j = index + 1; j <= s.length(); j++) {
            String cur = s.substring(index, j);
            if (dict.contains(cur)) {
                if (isWordBreakPossible(s, dict, j, memo)) {
                    memo[index] = 1;
                    return true;
                }
            }
        }
        memo[index] = 0;
        return false;
    }
}
