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

    public static int longestCommonSubsequence(String text1, String text2) {
        byte[] one = text1.getBytes();
        byte[] two = text2.getBytes();
        dp = new int[one.length + 1][two.length + 1];
        for (int i = 1; i <= one.length; i++) {
            for (int j = 1; j <= two.length; j++) {
                if (one[i - 1] == two[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[one.length][two.length];
    }

    public static int longestCommonSubsequenceRecur(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++)
            Arrays.fill(dp[i], -1);
        return lcs(text1.getBytes(), text2.getBytes(), 0, 0, text1.length(), text2.length());
    }

    private static int lcs(byte[] one, byte[] two, int i, int j, int n, int m) {
        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = 0;
        if (one[i] == two[j]) {
            res = 1 + lcs(one, two, i + 1, j + 1, n, m);
        } else {
            res = Math.max(lcs(one, two, i, j + 1, n, m), lcs(one, two, i + 1, j, n, m));
        }
        dp[i][j] = res;
        return res;
    }
}
