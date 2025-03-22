package dp;

/**
 * Problem URL: https://leetcode.com/problems/palindromic-substrings/description
 * Level: Medium
 */

public class PalindromicSubstrings {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PalindromicSubstrings.countSubstrings("abc"));

        // Case 2
        System.out.println(PalindromicSubstrings.countSubstrings("aaa"));
    }

    public static int countSubstringsLookupTable(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            result++;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result++;
            }
        }
        for (int step = 2; step < len; step++) {
            for (int i = 0, j = step; j < len; i++, j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                result += dp[i][j] ? 1 : 0;
            }
        }
        return result;
    }

    public static int countSubstrings(String s) {
        int len = s.length();
        byte[] chars = s.getBytes();
        int result = 0;
        if (len < 2) return 1;
        for (int i = 0; i < len; i++) {
            result++;
            int prev = i - 1, nxt = i + 1;
            while (prev >= 0 && nxt < len && chars[prev] == chars[nxt]) {
                prev -= 1;
                nxt += 1;
                result += 1;
            }
            prev = i - 1;
            nxt = i;
            while (prev >= 0 && nxt < len && chars[prev] == chars[nxt]) {
                prev -= 1;
                nxt += 1;
                result += 1;
            }
        }
        return result;
    }
}
