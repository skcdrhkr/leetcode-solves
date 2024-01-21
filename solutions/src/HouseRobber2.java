/**
 * Problem URL: https://leetcode.com/problems/house-robber-ii/description/
 * Level: Medium
 */

public class HouseRobber2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(HouseRobber2.rob(new int[]{2, 3, 2}));

        // Case 2
        System.out.println(HouseRobber2.rob(new int[]{1, 2, 3, 1}));

        // Case 3
        System.out.println(HouseRobber2.rob(new int[]{1, 2, 3}));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int first = 0, second = 0, temp;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        for (int i = 0; i < n - 1; i++) {
            temp = Math.max(nums[i] + first, second);
            first = second;
            second = temp;
        }
        int res = second;
        first = 0;
        second = 0;
        for (int i = 1; i < n; i++) {
            temp = Math.max(nums[i] + first, second);
            first = second;
            second = temp;
        }
        return Math.max(res, second);
    }
}
