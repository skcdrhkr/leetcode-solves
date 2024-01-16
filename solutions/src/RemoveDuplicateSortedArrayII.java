/**
 * Problem URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * Level: Medium
 */

public class RemoveDuplicateSortedArrayII {

    public static void main(String[] args) {
        // Case 1
        System.out.println(RemoveDuplicateSortedArrayII.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));

        // Case 2
        System.out.println(RemoveDuplicateSortedArrayII.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int res = 1;
        if (n == 1 || n == 2)
            return n;
        int cur = 1;
        int i = 1;
        while (i < n) {
            if (nums[i] == nums[i - 1])
                cur++;
            else {
                cur = 1;
            }
            nums[res] = nums[i];
            if (cur <= 2) {
                res += 1;
            }
            i += 1;
        }
        return res;
    }
}
