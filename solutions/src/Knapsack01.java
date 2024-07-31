public class Knapsack01 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Knapsack01.findMaxKnapsackProfit(6, new int[]{1, 2, 3, 5}, new int[]{1, 5, 4, 8}));

        // Case 2
        System.out.println(Knapsack01.findMaxKnapsackProfit(15, new int[]{2, 4, 10, 5, 4, 6, 7, 3}, new int[]{12, 43, 23, 35, 14, 61, 27, 63}));
    }

    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        // Replace this placeholder return statement with your code
        int[] dp = new int[capacity + 1];
        for (int row = 0; row < weights.length; row++) {
            for (int col = capacity; col >= weights[row]; col--) {
                dp[col] = Math.max(dp[col], dp[col - weights[row]] + values[row]);
            }
        }
        return dp[capacity];
    }
}
