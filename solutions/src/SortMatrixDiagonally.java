/**
 * Online Assessment Leetcode
 */

import java.util.Arrays;

public class SortMatrixDiagonally {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(SortMatrixDiagonally.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})));

        // Case 2
        System.out.println(Arrays.deepToString(SortMatrixDiagonally.diagonalSort(new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}})));
    }

    public static int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if (n == 1 || m == 1)
            return mat;
        int[] freq = new int[101];

        for (int i = m - 2; i >= 0; i--) {
            count(mat, 0, i, n, m, freq);
            place(mat, 0, i, n, m, freq);
        }
        for (int i = 1; i < n - 1; i++) {
            count(mat, i, 0, n, m, freq);
            place(mat, i, 0, n, m, freq);
        }
        return mat;
    }

    private static void count(int[][] mat, int row, int col, int n, int m, int[] freq) {
        Arrays.fill(freq, 0);
        while (row < n && col < m) {
            freq[mat[row++][col++]]++;
        }

    }

    private static void place(int[][] mat, int row, int col, int n, int m, int[] freq) {
        for (int ind = 1; ind <= 100; ) {
            if (freq[ind] == 0) {
                ind++;
            } else {
                mat[row++][col++] = ind;
                freq[ind]--;
            }
        }
    }
}
