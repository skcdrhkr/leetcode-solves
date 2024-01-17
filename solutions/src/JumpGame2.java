/**
 * Problem URL: https://leetcode.com/problems/jump-game/description/
 * Level: Medium
 */

public class JumpGame2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(JumpGame2.canJump(new int[]{2, 3, 1, 1, 4}));

        // Case 2
        System.out.println(JumpGame2.canJump(new int[]{2, 3, 0, 1, 4}));
    }

    public static int canJump(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        int i = 0;
        int mx_reach = 1;
        int cur_reach = 1;
        while (i < n) {
            if (nums[i] == 0) {
                i += 1;
                continue;
            }
            cur_reach = mx_reach;
            while (cur_reach <= nums[i] + i && cur_reach < n) {
                dp[cur_reach] = dp[i] + 1;
                cur_reach += 1;
            }
            if (cur_reach == n) {
                return dp[n - 1];
            }
            if (cur_reach > mx_reach)
                mx_reach = cur_reach;
            i += 1;
        }
        return dp[n - 1];
    }

}
