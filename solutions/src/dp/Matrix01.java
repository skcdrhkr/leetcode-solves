package dp;

import java.util.Arrays;
import java.util.LinkedList;

public class Matrix01 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(Matrix01.updateMatrix(new int[][]{{0, 0, 1}, {0, 1, 1}, {1, 0, 1}})));

        // Case 2
        System.out.println(Arrays.deepToString(Matrix01.updateMatrix(new int[][]{{0, 1, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}})));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 1) {
                    mat[i][j] = mat[i - 1][j] + 1;
                }
                if (j > 1) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][j - 1] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i < (n - 1)) {
                    mat[i][j] = Math.min(mat[i][j], mat[i + 1][j] + 1);
                }
                if (j < (n - 1)) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][j + 1] + 1);
                }
            }
        }
        return mat;
    }

    public static int[][] updateMatrixBFS(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int siz = queue.size();
            while (siz > 0) {
                siz -= 1;
                int[] top = queue.poll();
                int[] x = new int[]{0, 1, 0, -1};
                int[] y = new int[]{1, 0, -1, 0};
                for (int i = 0; i < 4; i++) {
                    int p = top[0] + x[i];
                    int q = top[1] + y[i];
                    if (p >= 0 && p < n && q >= 0 && q < m) {
                        if (mat[p][q] != 0 && mat[p][q] > (mat[top[0]][top[1]] + 1)) {
                            mat[p][q] = mat[top[0]][top[1]] + 1;
                            queue.add(new int[]{p, q});
                        }
                    }
                }
            }
        }
        return mat;
    }
}
