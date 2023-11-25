/**
 * Problem URL: https://leetcode.com/problems/set-matrix-zeroes/description/
 * Level: Medium
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] case1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(case1);
        printMatrix(case1);
        int[][] case2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(case2);
        printMatrix(case2);
        int[][] case3 = new int[][]{{1, 0}};
        setZeroes(case3);
        printMatrix(case3);
    }

    static void printMatrix(int[][] matrix) {
        System.out.println("----------");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + ",");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean lastrowzero = false, thisrowzero = false;
        // Checking if last row will need to be zeroed out
        for (int j = 0; j < m; j++) {
            if (matrix[n - 1][j] == 0) {
                lastrowzero = true;
                break;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            thisrowzero = false;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    thisrowzero = true;
                    // Storing this column zero tracking in last row of matrix;
                    matrix[n - 1][j] = 0;
                }
            }
            if (thisrowzero) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Setting columns to zero based on last row
        for (int j = 0; j < m; j++) {
            if (matrix[n - 1][j] == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Setting last row to zero as initially stored in lastrowzero
        if (lastrowzero) {
            for (int j = 0; j < m; j++) {
                matrix[n - 1][j] = 0;
            }
        }
    }
}
