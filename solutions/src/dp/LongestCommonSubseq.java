package dp;

import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/longest-common-subsequence/description
 * Level: Medium
 */


public class LongestCommonSubseq {

    static int[][] dp;

    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestCommonSubseq.longestCommonSubsequence("abcde", "ace"));

        // Case 2
        System.out.println(LongestCommonSubseq.longestCommonSubsequence("abc", "abc"));

        // Case 3
        System.out.println(LongestCommonSubseq.longestCommonSubsequence("abc", "def"));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }
        return findLongestCommonSubsequence(text1, text2, text1.length(), text2.length(), 0, 0, memo);
    }

    private static int findLongestCommonSubsequence(String text1, String text2, int lenA, int lenB, int p, int q, int[][] memo) {
        if (p >= lenA || q >= lenB) {
            return 0;
        }
        if (memo[p][q] != -1) {
            return memo[p][q];
        }
        if (text1.charAt(p) == text2.charAt(q)) {
            memo[p][q] = findLongestCommonSubsequence(text1, text2, lenA, lenB, p + 1, q + 1, memo) + 1;
        } else {
            memo[p][q] = Math.max(findLongestCommonSubsequence(text1, text2, lenA, lenB, p, q + 1, memo),
                    findLongestCommonSubsequence(text1, text2, lenA, lenB, p + 1, q, memo));
        }
        return memo[p][q];
    }

    public static int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

}
