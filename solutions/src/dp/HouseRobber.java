package dp;

/**
 * Problem URL: https://leetcode.com/problems/house-robber/description/
 * Level: Medium
 */

public class HouseRobber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(HouseRobber.rob(new int[]{1, 2, 3, 1}));

        // Case 2
        System.out.println(HouseRobber.rob(new int[]{2, 7, 9, 3, 1}));

        // Case 3
        System.out.println(HouseRobber.rob(new int[]{4, 2, 6, 3, 2, 6, 9, 4, 1, 0, 3, 2, 4, 8, 0, 3}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int inc = nums[0], exc = 0;
        int temp;
        for(int i=1;i<len;i++) {
            temp = exc + nums[i];
            exc  = Math.max(inc,exc);
            inc = temp;
        }
        return Math.max(inc,exc);
    }
}
