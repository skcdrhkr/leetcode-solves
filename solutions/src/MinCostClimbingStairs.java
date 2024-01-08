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
        int n = cost.length;
        if (n == 2)
            return Math.min(cost[0], cost[1]);
        int temp;
        int first = 0, second = 0;
        for (int i = 2; i <= n; i++) {
            temp = Math.min(second + cost[i - 1], first + cost[i - 2]);
            first = second;
            second = temp;
        }
        return second;
    }
}
