import java.util.Arrays;

public class LargestLocalValueMatrix {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(LargestLocalValueMatrix.largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));

        // Case 2
        System.out.println(Arrays.deepToString(LargestLocalValueMatrix.largestLocal(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}})));

        // Case 3
        System.out.println(Arrays.deepToString(LargestLocalValueMatrix.largestLocal(new int[][]{{20, 8, 20, 6, 16, 16, 7, 16, 8, 10}, {12, 15, 13, 10, 20, 9, 6, 18, 17, 6}, {12, 4, 10, 13, 20, 11, 15, 5, 17, 1}, {7, 10, 14, 14, 16, 5, 1, 7, 3, 11}, {16, 2, 9, 15, 9, 8, 6, 1, 7, 15}, {18, 15, 18, 8, 12, 17, 19, 7, 7, 8}, {19, 11, 15, 16, 1, 3, 7, 4, 7, 11}, {11, 6, 5, 14, 12, 18, 3, 20, 14, 6}, {4, 4, 19, 6, 17, 12, 8, 8, 18, 8}, {19, 15, 14, 11, 11, 13, 12, 6, 16, 19}})));
    }

    public static int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] res = new int[len - 2][len - 2];
        for (int i = 1; i < len - 1; i++) {
            for (int j = 1; j < len - 1; j++) {
                int mx = -1;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (grid[x][y] > mx) {
                            mx = grid[x][y];
                        }
                    }
                }
                res[i - 1][j - 1] = mx;
            }
        }
        return res;
    }
}
