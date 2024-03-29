/**
 * Problem URL: https://leetcode.com/problems/minimum-path-sum/description/
 * Level: Medium
 */

public class MinPathSum {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinPathSum.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));

        // Case 2
        System.out.println(MinPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[n - 1][m - 1];
    }
}
