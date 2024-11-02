package dp;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(CountingBits.countingBits(10)));

        // Case 2
        System.out.println(Arrays.toString(CountingBits.countingBits(15)));
    }

    public static int[] countingBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
