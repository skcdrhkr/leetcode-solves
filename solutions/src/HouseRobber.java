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
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        int temp;
        for (int i = 2; i < n; i++) {
            temp = Math.max(nums[i] + first, second);
            first = second;
            second = temp;
        }
        return second;
    }
}
