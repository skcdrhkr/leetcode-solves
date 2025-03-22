package backtracking;

public class WordSearch {

    public static void main(String[] args) {
        // Case 1
        System.out.println(WordSearch.wordSearch(new char[][]{{'v', 'W', 'D'}}, "WD"));

        // Case 2
        System.out.println(WordSearch.wordSearch(new char[][]{{'L', 'S', 'T', 'I', 'M'}, {'I', 'I', 'L', 'M', 'O'}, {'S', 'K', 'I', 'E', 'O'}, {'P', 'T', 'A', 'S', 'J'}, {'M', 'X', 'T', 'A', 'C'}}, "GRAB"));
    }

    public static boolean wordSearch(char[][] grid, String word) {

        // Replace this placeholder return statement with your code
        int n = grid.length;
        int m = grid[0].length;
        int len = word.length();
        if (len > n * m) return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    boolean found = performDFSSearch(grid, word, i, j, 1);
                    if (found) return true;
                }
            }
        }
        return false;
    }

    private static boolean performDFSSearch(char[][] grid, String word, int x, int y, int index) {
        if (index == word.length())
            return true;
        int[] p = new int[]{-1, 0, 1, 0};
        int[] q = new int[]{0, 1, 0, -1};
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + p[i];
            int ny = y + q[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == word.charAt(index)) {
                char k = grid[x][y];
                grid[x][y] = '-';
                result = performDFSSearch(grid, word, nx, ny, index + 1);
                if (result) break;
                grid[x][y] = k;
            }
        }
        return result;
    }
}
