/**
 * Problem URL: https://leetcode.com/problems/minimum-falling-path-sum/description/
 * Level: Medium
 */

public class MinFallingPathSum {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinFallingPathSum.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));

        // Case 2
        System.out.println(MinFallingPathSum.minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        if (n == 1)
            return matrix[0][0];
        int[][] dp = new int[n][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]));
                }
                if (i == n - 1 && res > dp[i][j]) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
