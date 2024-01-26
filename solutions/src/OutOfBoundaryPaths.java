import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/out-of-boundary-paths/description/
 * Level: Medium
 */

public class OutOfBoundaryPaths {

    static int[][][] memo;
    static int MOD = 1000000007;

    public static void main(String[] args) {
        // Case 1
        int m = 2, n = 2, mm = 5;
        memo = new int[m][n][mm];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);
        }
        System.out.println(OutOfBoundaryPaths.findPaths(2, 2, 5, 1, 0));

        // Case 2
        m = 1;
        n = 3;
        mm = 3;
        memo = new int[m][n][mm];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                Arrays.fill(memo[i][j], -1);
        }
        System.out.println(OutOfBoundaryPaths.findPaths(1, 3, 3, 0, 1));

        m = 8;
        n = 50;
        mm = 23;
        memo = new int[m][n][mm];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        System.out.println(OutOfBoundaryPaths.findPaths(m, n, mm, 5, 26)); //914783380
    }

    public static int findPaths(int m, int n, int mm, int sr, int sc) {
        if (sr >= m || sr < 0 || sc >= n || sc < 0)
            return 1;
        if (mm <= 0)
            return 0;
        if (memo[sr][sc][mm - 1] != -1)
            return memo[sr][sc][mm - 1];

        int left = findPaths(m, n, mm - 1, sr, sc - 1);
        int right = findPaths(m, n, mm - 1, sr, sc + 1);
        int up = findPaths(m, n, mm - 1, sr - 1, sc);
        int down = findPaths(m, n, mm - 1, sr + 1, sc);
        memo[sr][sc][mm - 1] = (((left % MOD + right % MOD) % MOD + up % MOD) % MOD + down % MOD) % MOD;
        return memo[sr][sc][mm - 1];
    }
}
