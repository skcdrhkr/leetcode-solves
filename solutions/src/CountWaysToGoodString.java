import java.util.Arrays;

public class CountWaysToGoodString {

    final static int MOD = 1000000007;

    public static void main(String[] args) {
        // Case 1
        System.out.println(CountWaysToGoodString.countGoodStrings(3, 3, 1, 1));

        // Case 2
        System.out.println(CountWaysToGoodString.countGoodStrings(2, 3, 1, 2));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        int cur = 0;
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return countWays(low, high, zero, one, cur, dp);
    }

    private static int countWays(int low, int high, int zero, int one, int cur, int[] dp) {
        if (cur > high)
            return 0;
        int res = 0;
        if (dp[cur] != -1)
            return dp[cur];
        if (cur >= low)
            res = 1;
        int zeroes = countWays(low, high, zero, one, cur + zero, dp);
        int ones = countWays(low, high, zero, one, cur + one, dp);
        res = ((((res % MOD) + (zeroes % MOD)) % MOD) + (ones % MOD)) % MOD;
        dp[cur] = res;
        return res;
    }
}
