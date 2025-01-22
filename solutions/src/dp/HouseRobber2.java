package dp;

/**
 * Problem URL: https://leetcode.com/problems/house-robber-ii/description/
 * Educative: https://www.educative.io/courses/grokking-coding-interview/house-robber-ii
 * Level: Medium
 */

public class HouseRobber2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(HouseRobber2.rob(new int[]{2, 3, 2}));

        // Case 2
        System.out.println(HouseRobber2.rob(new int[]{1, 2, 3, 1}));

        // Case 3
        System.out.println(HouseRobber2.rob(new int[]{1, 5, 7, 3, 7, 2, 3}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int excludingPrev = 0, includingPrev = 0, temp;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        for (int i = 0; i < len - 1; i++) {
            temp = Math.max(excludingPrev + nums[i], includingPrev);
            excludingPrev = includingPrev;
            includingPrev = temp;
        }
        int res = includingPrev;
        includingPrev = 0;
        excludingPrev = 0;

        for (int i = 1; i < len; i++) {
            temp = Math.max(excludingPrev + nums[i], includingPrev);
            excludingPrev = includingPrev;
            includingPrev = temp;
        }
        return Math.max(res, includingPrev);
    }
}
