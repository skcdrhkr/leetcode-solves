import java.util.Arrays;

public class DiceRollsTargetSum {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        // Case 1
        System.out.println(DiceRollsTargetSum.numRollsToTarget(30, 30, 500));

        // Case 2
        System.out.println(DiceRollsTargetSum.numRollsToTarget(1, 2, 3));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        if (n * k < target) return 0;
        if (n > target) return 0;
        int[][] memo = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        rollToTarget(n, k, target, memo);
        return memo[n][target];
    }

    private static int rollToTarget(int n, int k, int target, int[][] memo) {
        if (n == 0) {
            if (target == 0) return 1;
            else return 0;
        }
        if (target < 0) return 0;
        if (n * k < target) return 0;
        if (n > target) return 0;
        if (memo[n][target] != -1) return memo[n][target];
        int count = 0;
        for (int i = 1; i <= k; i++) {
            count = ((count % MOD) + rollToTarget(n - 1, k, target - i, memo) % MOD) % MOD;
        }
        memo[n][target] = count;
        return count;
    }
}
