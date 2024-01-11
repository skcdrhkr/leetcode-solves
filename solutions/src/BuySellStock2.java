/**
 * Problem URL: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 * Level: Medium
 */

public class BuySellStock2 {
    public static void main(String[] args) {
        // Case 1
        System.out.println(BuySellStock2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        // Case 2
        System.out.println(BuySellStock2.maxProfit(new int[]{1, 2, 3, 4, 5}));
        // Case 3
        System.out.println(BuySellStock2.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int res = 0, min;
        int n = prices.length;
        if (n == 1)
            return res;
        min = prices[0];
        for (int i = 1; i < n; i++) {
            if (min <= prices[i]) {
                res += (prices[i] - min);
            }
            min = prices[i];
        }
        return res;
    }
}
