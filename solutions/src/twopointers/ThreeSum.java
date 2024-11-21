/**
 * Problem URL: https://leetcode.com/problems/3sum/description/
 * Level: Medium
 */

package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(ThreeSum.threeSum(new int[]{0, 1, 1}));
        System.out.println(ThreeSum.threeSum(new int[]{0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j, k;
        if (nums[0] > 0)
            return result;
        while (i < n - 1) {

            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
            while (i < n - 2 && nums[i] == nums[i - 1])
                i++;
        }
        return result;
    }
}