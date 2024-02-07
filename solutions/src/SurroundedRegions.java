import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/surrounded-regions/description/
 * Level: Medium
 */

public class SurroundedRegions {

    public static void main(String[] args) {
        // Case 1
        char[][] case1 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        SurroundedRegions.solve(case1);
        System.out.println(Arrays.deepToString(case1));

        // Case 2
        char[][] case2 = new char[][]{{'X'}};
        SurroundedRegions.solve(case2);
        System.out.println(Arrays.deepToString(case2));
    }

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                saveThisOAndAdjacent(board, i, 0, n, m);
            }
            if (board[i][m - 1] == 'O') {
                saveThisOAndAdjacent(board, i, m - 1, n, m);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                saveThisOAndAdjacent(board, 0, j, n, m);
            }
            if (board[n - 1][j] == 'O') {
                saveThisOAndAdjacent(board, n - 1, j, n, m);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'S')
                    board[i][j] = 'O';
            }
        }
    }

    private static void saveThisOAndAdjacent(char[][] board, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0 || board[i][j]=='X' || board[i][j]=='S')
            return;
        board[i][j] = 'S';
        saveThisOAndAdjacent(board, i - 1, j, n, m);
        saveThisOAndAdjacent(board, i + 1, j, n, m);
        saveThisOAndAdjacent(board, i, j + 1, n, m);
        saveThisOAndAdjacent(board, i, j - 1, n, m);
    }
}
