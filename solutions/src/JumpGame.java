/**
 * Problem URL: https://leetcode.com/problems/jump-game/description/
 * Level: Medium
 */

public class JumpGame {

    public static void main(String[] args) {
        // Case 1
        System.out.println(JumpGame.canJump(new int[]{2, 3, 1, 1, 4}));

        // Case 2
        System.out.println(JumpGame.canJump(new int[]{3, 2, 1, 0, 4}));

        // Case 3
        System.out.println(JumpGame.canJump(new int[]{3, 1, 0, 1, 2, 0, 1, 0, 1}));

        // Case 4
        System.out.println(JumpGame.canJump(new int[]{3, 0, 0, 1, 2, 0, 0}));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;
        if (nums[0] == 0)
            return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;
        int mx = 0, cur;
        for (int i = 0; i < n; i++) {
            if (!dp[i])
                continue;
            cur = nums[i] + i;
            if (mx >= cur)
                continue;
            while (mx <= cur && mx < n) {
                dp[mx] = true;
                mx += 1;
            }
            mx = cur;
        }

        return dp[n - 1];
    }

}
