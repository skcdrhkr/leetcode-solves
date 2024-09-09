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
        // 0 = ball falling from top, 1 = ball coming from left side, 2 = ball coming from right side;
        int direction = 0;
        int[] res = new int[m];
        for (int ind = 0; ind < m; ind++) {
            int row = 0, col = ind;
            boolean stuck = false;
            direction = 0;
            while (row < n && col >= 0 && col < m) {
                if (grid[row][col] == 1) {
                    if (direction == 0) {
                        col++;
                        direction = 1;
                    } else if (direction == 1) {
                        row++;
                        direction = 0;
                    } else if (direction == 2) {
                        stuck = true;
                        break;
                    }
                } else {
                    if (direction == 0) {
                        col--;
                        direction = 2;
                    } else if (direction == 1) {
                        stuck = true;
                        break;
                    } else if (direction == 2) {
                        row++;
                        direction = 0;
                    }
                }
            }
            if (stuck || row != n) {
                res[ind] = -1;
            } else {
                res[ind] = col;
            }
        }
        return res;
    }
}
