/**
 * Problem URL: https://leetcode.com/problems/number-of-islands/description/
 * Level: Medium
 */

public class NumberOfIslands {

    public static void main(String[] args) {
        // Case 1
        System.out.println(NumberOfIslands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));

        // Case 2
        System.out.println(NumberOfIslands.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    res += 1;
                }

            }
        }
        return res;
    }

    public static void dfs(char[][] grid, int p, int q, int n, int m) {
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};
        grid[p][q] = '0';
        for (int i = 0; i < 4; i++) {
            int d = p + x[i];
            int f = q + y[i];
            if (d >= 0 && d < n && f >= 0 && f < m && grid[d][f] == '1') {
                dfs(grid, d, f, n, m);
            }
        }
    }
}
