public class MinFallingPathSum2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinFallingPathSum2.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));

        // Case 2
        System.out.println(MinFallingPathSum2.minFallingPathSum(new int[][]{{7}}));

        // Case 3
        System.out.println(MinFallingPathSum2.minFallingPathSum(new int[][]{{-73, 61, 43, -48, -36}, {3, 30, 27, 57, 10}, {96, -76, 84, 59, -15}, {5, -49, 76, 31, -7}, {97, 91, 61, -46, 67}}));
    }

    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prevMinFirst = -1;
        int prevMinSecond = -1;
        for (int j = 0; j < m; j++) {
            if (prevMinFirst == -1) {
                prevMinFirst = j;
            } else if (prevMinSecond == -1) {
                if (grid[0][prevMinFirst] > grid[0][j]) {
                    prevMinSecond = prevMinFirst;
                    prevMinFirst = j;
                } else {
                    prevMinSecond = j;
                }
            } else if (grid[0][prevMinFirst] > grid[0][j]) {
                prevMinSecond = prevMinFirst;
                prevMinFirst = j;
            } else if (grid[0][prevMinSecond] > grid[0][j]) {
                prevMinSecond = j;
            }
        }

        for (int i = 1; i < n; i++) {
            int curMinFirst = -1;
            int curMinSecond = -1;
            for (int j = 0; j < m; j++) {
                grid[i][j] = grid[i][j] + (j == prevMinFirst ? grid[i - 1][prevMinSecond] : grid[i - 1][prevMinFirst]);
                if (curMinFirst == -1) {
                    curMinFirst = j;
                } else if (curMinSecond == -1) {
                    if (grid[i][curMinFirst] > grid[i][j]) {
                        curMinSecond = curMinFirst;
                        curMinFirst = j;
                    } else {
                        curMinSecond = j;
                    }
                } else if (grid[i][curMinFirst] > grid[i][j]) {
                    curMinSecond = curMinFirst;
                    curMinFirst = j;
                } else if (grid[i][curMinSecond] > grid[i][j]) {
                    curMinSecond = j;
                }
            }
            prevMinFirst = curMinFirst;
            prevMinSecond = curMinSecond;
        }
        return grid[n - 1][prevMinFirst];
    }
}
