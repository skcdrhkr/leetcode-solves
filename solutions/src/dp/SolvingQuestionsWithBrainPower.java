package dp;

import java.util.Arrays;

public class SolvingQuestionsWithBrainPower {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SolvingQuestionsWithBrainPower.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));

        // Case 2
        System.out.println(SolvingQuestionsWithBrainPower.mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}));
    }

    private static long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len + 1];
        for (int ind = len - 1; ind >= 0; ind--) {
            long take = questions[ind][0];
            int nextInd = ind + questions[ind][1] + 1;
            take = take + (nextInd > len ? 0 : dp[nextInd]);
            long nottake = dp[ind + 1];
            dp[ind] = Math.max(take, nottake);
        }
        return dp[0];
    }

    public static long mostPointsTopDown(int[][] questions) {
        int len = questions.length;
        long[] memo = new long[len + 1];
        Arrays.fill(memo, -1);
        return findMostPoints(questions, 0, len, memo);
    }

    private static long findMostPoints(int[][] questions, int ind, int len, long[] memo) {
        if (ind >= len) {
            return 0;
        }
        if (memo[ind] != -1) return memo[ind];
        long solve = findMostPoints(questions, ind + questions[ind][1] + 1, len, memo) + questions[ind][0];
        solve = Math.max(solve, findMostPoints(questions, ind + 1, len, memo));
        memo[ind] = solve;
        return solve;
    }
}
