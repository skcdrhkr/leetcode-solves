import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * Level: Medium
 */

public class LongestPalindromicSubseq {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestPalindromicSubseq.longestPalindromeSubseq("bbbab"));

        // Case 2
        System.out.println(LongestPalindromicSubseq.longestPalindromeSubseq("cbbd"));
    }

    public static int longestPalindromeSubseq(String s) {
        byte[] bts = s.getBytes();
        int n = bts.length;
        if(n==1)
            return n;
        int[][] memo = new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(memo[i],-1);
        }
        return lps(bts,memo,0,n-1);
    }

    private static int lps(byte[] bts, int[][] memo, int st, int end) {
        if (st == end)
            return 1;
        if (st == (end - 1)) {
            if (bts[st] == bts[end])
                return 2;
            else
                return 1;
        }
        if (memo[st][end] != -1)
            return memo[st][end];
        if (bts[st] != bts[end]) {
            memo[st][end] = Math.max(lps(bts, memo, st + 1, end), lps(bts, memo, st, end - 1));
        } else {
            memo[st][end] = lps(bts, memo, st + 1, end - 1) + 2;
        }
        return memo[st][end];
    }
}
