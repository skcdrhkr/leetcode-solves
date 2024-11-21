/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/3sum
 */

package twopointers;

import java.util.Arrays;

public class SumOfThree {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SumOfThree.findSumOfThree(new int[]{1, -1, 0}, -1));

        // Case 2
        System.out.println(SumOfThree.findSumOfThree(new int[]{3, 7, 1, 2, 8, 4, 5}, 21));

        // Case 3
        System.out.println(SumOfThree.findSumOfThree(new int[]{-1, 2, 1, -4, 5, -3}, 0));
    }

    public static boolean findSumOfThree(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target - nums[i]) {
                    return true;
                } else if (nums[j] + nums[k] < target - nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return false;
    }
}