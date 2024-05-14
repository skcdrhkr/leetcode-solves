public class PathWithMaxGold {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PathWithMaxGold.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));

        // Case 2
        System.out.println(PathWithMaxGold.getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }

    public static int getMaximumGold(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    int cur = collectGold(grid, i, j, n, m);
                    if (cur > mx) {
                        mx = cur;
                    }
                }
            }
        }
        return mx;
    }

    private static int collectGold(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return 0;
        int[] x = new int[]{-1, 1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        int save = grid[i][j];
        grid[i][j] = 0;
        int mx = 0;
        for (int k = 0; k < 4; k++) {
            int p = x[k] + i;
            int q = y[k] + j;
            int cur = collectGold(grid, p, q, n, m) + save;
            if (mx < cur) {
                mx = cur;
            }
        }
        grid[i][j] = save;
        return mx;
    }
}
