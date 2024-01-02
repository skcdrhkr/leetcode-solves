/**
 * Problem URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Level: Easy
 */

public class BuySellStock {
    public static void main(String[] args) {
        // Case 1
        System.out.println(BuySellStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        // Case 2
        System.out.println(BuySellStock.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int res = 0, min;
        int n = prices.length;
        if (n == 1)
            return res;
        min = prices[0];
        for (int i = 1; i < n; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (res < (prices[i] - min)) {
                res = prices[i] - min;
            }
        }
        return res;
    }
}
