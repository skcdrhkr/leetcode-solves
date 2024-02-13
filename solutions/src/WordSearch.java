/**
 * Problem URL: https://leetcode.com/problems/word-search/description/
 * Level: Medium
 */

public class WordSearch {

    public static void main(String[] args) {
        // Case 1
        System.out.println(WordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));

        // Case 2
        System.out.println(WordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));

        // Case 3
        System.out.println(WordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        char[] wod = word.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == wod[0]) {
                    if (dfs(board, n, m, wod, i, j, 0, vis))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int n, int m, char[] wod, int i, int j, int ind, boolean[][] vis) {
        if (ind == wod.length) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '.') {
            return false;
        }
        boolean result = false;
        char temp;
        if (wod[ind] == board[i][j]) {
            temp = board[i][j];
            board[i][j] = '.';
            result = dfs(board, n, m, wod, i + 1, j, ind+1, vis) || dfs(board, n, m, wod, i - 1, j, ind+1, vis)
                    || dfs(board, n, m, wod, i, j + 1, ind+1, vis) || dfs(board, n, m, wod, i, j - 1, ind+1, vis);
            board[i][j] = temp;
        }
        return result;
    }
}
