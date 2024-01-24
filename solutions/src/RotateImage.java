import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/rotate-image/description/
 * Level: Medium
 */

public class RotateImage {

    public static void main(String[] args) {
        // Case 1
        int[][] case1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage.rotate(case1);
        System.out.println(Arrays.deepToString(case1));

        // Case 2
        int[][] case2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        RotateImage.rotate(case2);
        System.out.println(Arrays.deepToString(case2));
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] += matrix[j][i];
                matrix[j][i] = matrix[i][j] - matrix[j][i];
                matrix[i][j] = matrix[i][j] - matrix[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(matrix, i, n);
        }
    }

    private static void reverse(int[][] matrix, int row, int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            matrix[row][i] += matrix[row][j];
            matrix[row][j] = matrix[row][i] - matrix[row][j];
            matrix[row][i] = matrix[row][i] - matrix[row][j];
            i++;
            j--;
        }
    }
}
