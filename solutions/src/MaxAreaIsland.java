/**
 * Problem URL: https://leetcode.com/problems/max-area-of-island/
 * Level: Medium
 */

public class MaxAreaIsland {

    public static void main(String[] args) {

    }

    private static int dfs(int[][] grid, int a, int b, int n, int m) {
        if (a < 0 || a >= n || b < 0 || b >= m || grid[a][b] == 0) return 0;
        grid[a][b] = 0;
        int curarea = 0;
        curarea = dfs(grid, a + 1, b, n, m) + dfs(grid, a - 1, b, n, m) + dfs(grid, a, b + 1, n, m) + dfs(grid, a, b - 1, n, m) + 1;
        return curarea;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0, area;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    area = dfs(grid, i, j, n, m);
                    if (area > res) res = area;
                }
            }
        }
        return res;
    }
}
