/**
 * Problem URL: https://leetcode.com/problems/coin-change/description
 * Level: Medium
 */

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CoinChange.coinChange(new int[]{1, 2, 5}, 11));

        // Case 2
        System.out.println(CoinChange.coinChange(new int[]{2}, 3));

        // Case 3
        System.out.println(CoinChange.coinChange(new int[]{1}, 0));
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] memo = new int[amount + 1];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(memo[i], -1);
//        }
//        int res = coinChangeRecur(coins, 0, amount, memo);
//        return res == Integer.MAX_VALUE ? -1 : res;
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int coin : coins) {
            for (int k = coin; k <= amount; k++) {
                memo[k] = Math.min(memo[k], memo[k - coin] + 1);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    private static int coinChangeRecur(int[] coins, int i, int amount, int[][] memo) {
        if (i >= coins.length && amount > 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0)
            return 0;
        else if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][amount] != -1)
            return memo[i][amount];
        int nslct = coinChangeRecur(coins, i + 1, amount, memo);
        int slct = coinChangeRecur(coins, i, amount - coins[i], memo);
        if (slct != Integer.MAX_VALUE)
            slct += 1;
        memo[i][amount] = Math.min(slct, nslct);
        return memo[i][amount];
    }
}
