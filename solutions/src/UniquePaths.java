/**
 * Problem URL: https://leetcode.com/problems/unique-paths/description
 * Level: Medium
 */

public class UniquePaths {

    public static void main(String[] args) {
        // Case 1
        System.out.println(UniquePaths.uniquePaths(3, 7));

        // Case 2
        System.out.println(UniquePaths.uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
