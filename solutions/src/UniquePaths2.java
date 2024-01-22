/**
 * Problem URL: https://leetcode.com/problems/unique-paths-ii/description/
 * Level: Medium
 */

public class UniquePaths2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(UniquePaths2.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

        // Case 2
        System.out.println(UniquePaths2.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));

        // Case 3
        System.out.println(UniquePaths2.uniquePathsWithObstacles(new int[][]{{0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] og) {
        int n = og.length;
        int m = og[0].length;
        if (og[0][0] == 1)
            return 0;
        boolean isBlocked = false;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (og[i][0] == 1) {
                isBlocked = true;
            }
            if (isBlocked) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        isBlocked = false;
        for (int j = 0; j < m; j++) {
            if (og[0][j] == 1) {
                isBlocked = true;
            }
            if (isBlocked) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (og[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
