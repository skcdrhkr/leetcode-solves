/**
 * Problem URL: https://leetcode.com/problems/minimum-size-subarray-sum/description
 * Level: Medium
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinimumSizeSubarraySum.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        // Case 2
        System.out.println(MinimumSizeSubarraySum.minSubArrayLen(4, new int[]{1, 4, 4}));

        // Case 3
        System.out.println(MinimumSizeSubarraySum.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int cursum = 0;
        int i = 0, j = 0;
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        while (i < n) {
            while (j < n && cursum < target) {
                cursum += nums[j++];
            }
            if (j == n && cursum < target) break;
            if (res > (j - i)) {
                res = j - i;
            }
            cursum -= nums[i++];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
