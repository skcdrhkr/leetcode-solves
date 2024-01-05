/**
 * Problem URL: https://leetcode.com/problems/longest-increasing-subsequence/description
 * Level: Medium
 */

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // Case 2
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        // Case 3
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        // Case 4
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(new int[]{0, 3, 0, 5, 1, 2}));
    }

    //O(n2) DP
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int mx, res = 1;
        int[] lis = new int[n];
        lis[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            mx = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    mx = Math.max(mx, lis[j] + 1);
                }
            }
            lis[i] = mx;
            res = Math.max(res, mx);
        }
        return res;
    }
}
