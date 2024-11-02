package matrices;

public class TransposeMatrix {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SpiralMatrix.spiralOrder(new int[][]{{1}}));
        // Case 2
        System.out.println(SpiralMatrix.spiralOrder(new int[][]{{6}, {2}}));

        // Case 3
        System.out.println(SpiralMatrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        // Case 4
        System.out.println(SpiralMatrix.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
