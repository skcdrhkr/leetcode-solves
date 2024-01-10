/**
 * Problem URL: https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/
 * Level: Easy
 */

public class RemoveDuplicatesSortedArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(RemoveDuplicatesSortedArray.removeDuplicates(new int[]{1, 1, 2}));

        // Case 2
        System.out.println(RemoveDuplicatesSortedArray.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1, j = 1;
        while (i < n) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j += 1;
            }
            i += 1;
        }
        return j;
    }
}
