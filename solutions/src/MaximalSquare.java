/**
 * Problem URL: https://leetcode.com/problems/maximal-square/description
 * Level: Medium
 */


public class MaximalSquare {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaximalSquare.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));

        // Case 2
        System.out.println(MaximalSquare.maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));

        // Case 3
        System.out.println(MaximalSquare.maximalSquare(new char[][]{{'0'}}));
    }

    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int cur = 0;
        for (char[] chars : matrix) {
            if (chars[0] == '1') {
                cur = 1;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1') {
                cur = 1;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != '0') {
                    matrix[i][j] = (char) ((1 + Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1])) - '0')+'0');
                    if (cur < matrix[i][j]-'0')
                        cur = matrix[i][j]-'0';
                }
            }
        }
        return cur * cur;
    }
}
