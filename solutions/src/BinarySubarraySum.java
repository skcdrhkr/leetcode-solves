/**
 * Problem URL: https://leetcode.com/problems/binary-subarrays-with-sum/description
 * Level: Medium
 */

import java.util.HashMap;

public class BinarySubarraySum {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BinarySubarraySum.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));

        // Case 2
        System.out.println(BinarySubarraySum.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));

        // Case 3
        System.out.println(BinarySubarraySum.numSubarraysWithSum(new int[]{1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0}, 3));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        mp.put(0, 1);
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (mp.containsKey(sum - goal)) {
                res += (mp.get(sum - goal));
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
