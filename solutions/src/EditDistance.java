/**
 * Problem URL: https://leetcode.com/problems/edit-distance/description
 * Level: Medium
 */


public class EditDistance {

    public static void main(String[] args) {
        // Case 1
        System.out.println(EditDistance.minDistance("horse", "ros"));

        // Case 2
        System.out.println(EditDistance.minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        byte[] one = word1.getBytes();
        byte[] two = word2.getBytes();
        int n = one.length, m = two.length;
        if (n == 0)
            return m;
        if (m == 0)
            return n;
        int[][] dp = new int[n + 1][m + 1];
        return getDistance(one, two, 0, 0, n, m, dp);
//        for (int i = 1; i <= n; i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 1; j <= m; j++) {
//            dp[0][j] = j;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if(one[i-1]==two[j-1]) {
//                    dp[i][j] = dp[i-1][j-1];
//                } else {
//                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i - 1][j - 1],dp[i][j-1]))+1;
//                }
//            }
//        }
//        return dp[n][m];
    }

    private static int getDistance(byte[] one, byte[] two, int i, int j, int n, int m, int[][] dp) {
        if (i >= n) {
            return m - j;
        }
        if (j >= m)
            return n - i;
        if (dp[i][j] != 0)
            return dp[i][j];
        int cur;
        if (one[i] == two[j]) {
            cur = getDistance(one, two, i + 1, j + 1, n, m, dp);
        } else {
            cur = Math.min(getDistance(one, two, i, j + 1, n, m, dp), Math.min(getDistance(one, two, i + 1, j + 1, n, m, dp), getDistance(one, two, i + 1, j, n, m, dp))) + 1;
        }
        dp[i][j] = cur;
        return cur;
    }
}
