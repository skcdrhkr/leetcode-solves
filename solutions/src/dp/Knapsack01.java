package dp;

import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Knapsack01.findMaxKnapsackProfitBottomUp(6, new int[]{1, 2, 3, 5}, new int[]{1, 5, 4, 8}));

        // Case 2
        System.out.println(Knapsack01.findMaxKnapsackProfitBottomUp(15, new int[]{2, 4, 10, 5, 4, 6, 7, 3}, new int[]{12, 43, 23, 35, 14, 61, 27, 63}));
    }

    private static int findMaxKnapsackProfitBottomUp(int capacity, int[] weights, int[] values) {
        int len = weights.length;
        int[] hash = new int[capacity + 1];
        for (int i = 0; i < len; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j >= weights[i]) {
                    hash[j] = Math.max(hash[j], hash[j - weights[i]] + values[i]);
                }
            }
        }
        return hash[capacity];
    }


    public static int findMaxKnapsackProfitTopDown(int capacity, int[] weights, int[] values) {
        // Replace this placeholder return statement with your code
        int len = weights.length;
        int[][] memo = new int[len][capacity + 1];
        for (int[] cur : memo) {
            Arrays.fill(cur, -1);
        }
        return getMaxKnapsackProfit(capacity, weights, values, 0, memo);
    }

    private static int getMaxKnapsackProfit(int capacity, int[] weights, int[] values, int ind, int[][] memo) {
        if (ind >= weights.length || capacity <= 0)
            return 0;
        if (memo[ind][capacity] != -1) return memo[ind][capacity];
        int currentValue = getMaxKnapsackProfit(capacity, weights, values, ind + 1, memo);
        if (capacity >= weights[ind]) {
            currentValue = Math.max(currentValue, getMaxKnapsackProfit(capacity - weights[ind], weights, values, ind + 1, memo) + values[ind]);
        }
        memo[ind][capacity] = currentValue;
        return currentValue;
    }
}
