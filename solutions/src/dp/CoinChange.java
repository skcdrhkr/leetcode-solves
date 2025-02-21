package dp;

import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/coin-change/description
 * Level: Medium
 */

public class CoinChange {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CoinChange.coinChange(new int[]{1, 2, 5}, 11));

        // Case 2
        System.out.println(CoinChange.coinChange(new int[]{1, 3, 4, 5}, 7));

        // Case 3
        System.out.println(CoinChange.coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        if (amount == 0) return 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                int inc = dp[j - coins[i]];
                if (inc != Integer.MAX_VALUE)
                    inc += 1;
                dp[j] = Math.min(dp[j], inc);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private static int coinChangeTopDown(int[] coins, int amount) {
        int len = coins.length;
        int[][] memo = new int[amount + 1][len + 1];
        if (amount == 0) return 0;
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        getCoinChange(coins, len, amount, memo);
        return memo[amount][len] == Integer.MAX_VALUE ? -1 : memo[amount][len];
    }

    private static int getCoinChange(int[] coins, int ind, int amount, int[][] memo) {
        if (amount == 0) {
            return 0;
        }
        if (ind == 0) return Integer.MAX_VALUE;
        if (memo[amount][ind] != -1) {
            return memo[amount][ind];
        }
        if (coins[ind - 1] <= amount) {
            int inc = getCoinChange(coins, ind, amount - coins[ind - 1], memo);
            if (inc != Integer.MAX_VALUE) inc += 1;
            memo[amount][ind] = Math.min(getCoinChange(coins, ind - 1, amount, memo), inc);
        } else {
            memo[amount][ind] = getCoinChange(coins, ind - 1, amount, memo);
        }
        return memo[amount][ind];
    }
}
