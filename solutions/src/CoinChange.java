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
        if (amount == 0) return 0;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                memo[j] = Math.min(memo[j], 1 + memo[j - coin]);
            }
        }

        return memo[amount] < amount + 1 ? memo[amount] : -1;
    }
}
