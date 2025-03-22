package backtracking;

public class NQueens {

    public static void main(String[] args) {
        // Case 1
        System.out.println(NQueens.solveNQueens(4));

        // Case 2
        System.out.println(NQueens.solveNQueens(6));

        // Case 3
        System.out.println(NQueens.solveNQueens(7));

        // Case 4
        System.out.println(NQueens.solveNQueens(8));
    }

    public static int solveNQueens(int n) {
        int[][] board = new int[n][n];
        int ways = 0;
        for (int x = 0; x < n; x++) {
            board[0][x] = 1;
            ways += findWaysToPlace(board, n, x + 1, n-1);
        }
        return ways;
    }

    private static int findWaysToPlace(int[][] board, int size, int x, int queens) {
        if (queens == 0) {
            return 1;
        }
        if (x == size) return 0;
        for (int j = 0; j < size; j++) {
            if (validPosition(board, x, j)) {
                board[x][j] = 1;
                return findWaysToPlace(board, size, x + 1, queens - 1);
            }
        }
        return 1;
    }

    private static boolean validPosition(int[][] board, int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 1) return false;
        }
        for (int j = y - 1; j >= 0; j--) {
            if (board[x][j] == 1) return false;
        }
        int ind = 1, i = x - ind, j = y - ind;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) return false;
            ind++;
            i = x - ind;
            j = y - ind;
        }
        ind = 1;
        i = x + ind;
        j = y - ind;
        while (i < board.length && j >= 0) {
            if (board[i][j] == 1) return false;
            ind++;
            i = x + ind;
            j = y - ind;
        }
        return true;
    }
}
