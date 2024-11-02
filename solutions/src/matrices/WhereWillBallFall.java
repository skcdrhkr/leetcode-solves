package matrices;

import java.util.Arrays;

public class WhereWillBallFall {
    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(WhereWillBallFall.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})));

        // Case 2
        System.out.println(Arrays.toString(WhereWillBallFall.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}})));

        // Case 3
        System.out.println(Arrays.toString(WhereWillBallFall.findBall(new int[][]{{1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1}, {1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1}, {-1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1}})));
    }

    public static int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] result = new int[m];
        Arrays.fill(result, -1);
        for (int col = 0; col < m; col++) {
            int curCol = col;
            for (int row = 0; row < n; row++) {
                int nextCol = curCol + grid[row][curCol];
                if (nextCol < 0 || nextCol >= m || (grid[row][curCol] != grid[row][nextCol])) {
                    break;
                }
                if (row == n - 1) {
                    result[col] = nextCol;
                }
                curCol = nextCol;
            }
        }
        return result;
    }
}
