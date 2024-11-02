package matrices;

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
        int len = matrix.length;
        int temp;
        for (int i = 0; i <= (len - 1) / 2; i++) {
            for (int j = i; j < (len - i - 1); j++) {
                temp = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
