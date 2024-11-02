package dp;

/**
 * Problem URL: https://leetcode.com/problems/n-th-tribonacci-number/description/
 * Level: Easy
 */

public class TribonacciNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TribonacciNumber.tribonacciBetter(7));

        // Case 2
        System.out.println(TribonacciNumber.tribonacciBetter(25));

    }

    public static int tribonacciBetter(int n) {
        if (n < 3)
            return n == 0 ? 0 : 1;
        int first = 0, second = 1, third = 1, cur;
        for (int i = 3; i <= n; i++) {
            cur = first + second + third;
            first = second;
            second = third;
            third = cur;
        }
        return third;
    }


    public static int tribonacciBottomUp(int n) {
        int[] dp = new int[n + 1];
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static int tribonacciTopDown(int n) {
        int[] memo = new int[n + 1];
        return getTribnocci(n, memo);
    }

    private static int getTribnocci(int n, int[] memo) {
        if (n == 0) return 0;
        if (n < 3) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = getTribnocci(n - 1, memo) + getTribnocci(n - 2, memo) + getTribnocci(n - 3, memo);
        return memo[n];
    }
}
