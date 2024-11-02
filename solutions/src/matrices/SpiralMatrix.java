package matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

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

    public static List<Integer> spiralOrderEducative(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = -1;
        int direction = 1;
        List<Integer> result = new ArrayList<>();

        while (rows > 0 && cols > 0) {
            for (int i = 0; i < cols; i++) {
                col += direction;
                result.add(matrix[row][col]);
            }
            rows--;

            for (int i = 0; i < rows; i++) {
                row += direction;
                result.add(matrix[row][col]);
            }
            cols--;

            direction *= -1;
        }

        return result;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int topLeft = 0, topRight = 0, bottomLeft = n - 1, bottomRight = m - 1;
        List<Integer> result = new ArrayList<>();
        while (result.size() < (n * m)) {
            int cur = topLeft;
            while (cur <= bottomRight) {
                result.add(matrix[topRight][cur++]);
            }
            if (result.size() == (n * m)) break;
            topRight++;
            cur = topRight;
            while (cur <= bottomLeft) {
                result.add(matrix[cur++][bottomRight]);
            }
            if (result.size() == (n * m)) break;
            bottomRight--;
            cur = bottomRight;
            while (cur >= topLeft) {
                result.add(matrix[bottomLeft][cur--]);
            }
            if (result.size() == (n * m)) break;
            bottomLeft--;
            cur = bottomLeft;
            while (cur >= topRight) {
                result.add(matrix[cur--][topLeft]);
            }
            topLeft++;
        }
        return result;
    }
}
