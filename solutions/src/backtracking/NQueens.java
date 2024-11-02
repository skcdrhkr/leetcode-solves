package backtracking;

public class NQueens {

    public static void main(String[] args) {
        // Case 1
        System.out.println(NQueens.solveNQueens(4));

        // Case 2
        System.out.println(NQueens.solveNQueens(6));
    }

    static int result;

    public static int solveNQueens(int n) {
        int[][] board = new int[n][n];
        result = 0;
        for (int row = 0; row < n; row++) {
            placeQueens(board, row, 0);
        }
        return result;
    }

    private static void placeQueens(int[][] board, int row, int col) {
        if (col == board.length) {
            result += 1;
            return;
        }
    }

}
