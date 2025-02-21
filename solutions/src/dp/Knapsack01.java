package dp;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Knapsack01.findMaxKnapsackProfit(6, new int[]{1, 2, 3, 5}, new int[]{1, 5, 4, 8}));

        // Case 2
        System.out.println(Knapsack01.findMaxKnapsackProfit(15, new int[]{2, 4, 10, 5, 4, 6, 7, 3}, new int[]{12, 43, 23, 35, 14, 61, 27, 63}));
    }

    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        int len = weights.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }

    private static int findMaxKnapsackProfitTopDown(int capacity, int[] weights, int[] values) {
        int len = weights.length;
        int[][] memo = new int[capacity + 1][len + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        getMaxKnapsackProfit(capacity, weights, values, len, memo);
        return memo[capacity][len];
    }

    private static int getMaxKnapsackProfit(int capacity, int[] weights, int[] values, int ind, int[][] memo) {
        if (ind == 0 || capacity == 0)
            return 0;
        if (memo[capacity][ind] != -1)
            return memo[capacity][ind];
        if (weights[ind - 1] <= capacity) {
            memo[capacity][ind] = Math.max(
                    getMaxKnapsackProfit(capacity - weights[ind - 1], weights, values, ind - 1, memo) + values[ind - 1],
                    getMaxKnapsackProfit(capacity, weights, values, ind - 1, memo)
            );
        } else {
            memo[capacity][ind] = getMaxKnapsackProfit(capacity, weights, values, ind - 1, memo);
        }
        return memo[capacity][ind];
    }

}
