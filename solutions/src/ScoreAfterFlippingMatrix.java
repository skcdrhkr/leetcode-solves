public class ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ScoreAfterFlippingMatrix.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));

        // Case 2
        System.out.println(ScoreAfterFlippingMatrix.matrixScore(new int[][]{{0}}));
    }

    public static int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i, n, m);
            }
        }
        int mx = n / 2, countZero;
        for (int j = 1; j < m; j++) {
            countZero = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 0) countZero++;
            }
            if (countZero > mx) {
                flipColumn(grid, j, n, m);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int twos = 0, count = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    count += (1 << twos);
                }
                twos++;
            }
            result += count;
        }
        return result;
    }

    private static void flipRow(int[][] grid, int x, int n, int m) {
        for (int j = 0; j < m; j++) {
            grid[x][j] = grid[x][j] == 0 ? 1 : 0;
        }
    }

    private static void flipColumn(int[][] grid, int y, int n, int m) {
        for (int i = 0; i < n; i++) {
            grid[i][y] = grid[i][y] == 0 ? 1 : 0;
        }
    }
}
