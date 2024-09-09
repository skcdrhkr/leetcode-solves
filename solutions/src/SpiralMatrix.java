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

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int size = n * m;
        List<Integer> result = new ArrayList<>();
        int topLeft = 0, topRight = 0, bottomRight = m - 1, bottomLeft = n - 1;
        for (int ind = 0; ind < size; ind++) {
            for (int j = topLeft; j <= bottomRight; j++) {
                result.add(matrix[topRight][j]);
            }
            topRight++;
            if (result.size() == size) break;
            for (int i = topRight; i <= bottomLeft; i++) {
                result.add(matrix[i][bottomRight]);
            }
            bottomRight--;
            if (result.size() == size) break;
            for (int j = bottomRight; j >= topLeft; j--) {
                result.add(matrix[bottomLeft][j]);
            }
            bottomLeft--;
            if (result.size() == size) break;
            for (int i = bottomLeft; i >= topRight; i--) {
                result.add(matrix[i][topLeft]);
            }
            topLeft++;
        }
        return result;
    }
}
