package dp;

/**
 * Problem URL: https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * Level: Easy
 */

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20}));

        // Case 2
        System.out.println(MinCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int prev = cost[0], cur = cost[1];
        int temp;
        for (int i = 2; i < len; i++) {
            temp = Math.min(prev, cur) + cost[i];
            prev = cur;
            cur = temp;
        }
        return Math.min(prev, cur);
    }
}
