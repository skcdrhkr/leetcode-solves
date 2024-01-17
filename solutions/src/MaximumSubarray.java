/**
 * Problem URL: https://leetcode.com/problems/maximum-subarray/description/
 * Level: Medium
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        // Case 2
        System.out.println(MaximumSubarray.maxSubArray(new int[]{1}));

        // Case 3
        System.out.println(MaximumSubarray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int mx = nums[0];
        int i = 1;
        while (i < n) {
            if (res < 0) {
                res = nums[i];
            } else {
                res += nums[i];
            }
            if (mx < res)
                mx = res;
            i += 1;
        }
        return mx;
    }
}
