package dp;
/**
 * Problem URL: https://leetcode.com/problems/coin-change/description
 * Level: Medium
 */

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CoinChange.coinChangeBottomUp(new int[]{1, 2, 5}, 11));

        // Case 2
        System.out.println(CoinChange.coinChangeBottomUp(new int[]{1, 3, 4, 5}, 7));

        // Case 3
        System.out.println(CoinChange.coinChangeBottomUp(new int[]{1}, 0));
    }

    public static int coinChangeBottomUp(int[] coins, int amount) {
        int[] hash = new int[amount + 1];
        Arrays.fill(hash, Integer.MAX_VALUE);
        hash[0] = 0;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    int prevAmount = hash[j - coin];
                    if (prevAmount != Integer.MAX_VALUE)
                        prevAmount += 1;
                    hash[j] = Math.min(hash[j], prevAmount);
                }
            }
        }
        return hash[amount] == Integer.MAX_VALUE ? -1 : hash[amount];
    }

    public static int coinChangeTopDown(int[] coins, int amount) {
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] cur : memo) {
            Arrays.fill(cur, -1);
        }
        Arrays.sort(coins);
        int result = getChangeOfCoins(coins, amount, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int getChangeOfCoins(int[] coins, int amount, int ind, int[][] memo) {
        if (amount == 0) return 0;
        if (ind >= coins.length || coins[ind] > amount) return Integer.MAX_VALUE;
        if (memo[ind][amount] != -1) return memo[ind][amount];
        int notUseCoin = getChangeOfCoins(coins, amount, ind + 1, memo);
        int useCoin = getChangeOfCoins(coins, amount - coins[ind], ind, memo);
        if (useCoin != Integer.MAX_VALUE) {
            useCoin += 1;
            memo[ind][amount] = Math.min(useCoin, notUseCoin);
        } else {
            memo[ind][amount] = notUseCoin;
        }
        return memo[ind][amount];
    }
}
