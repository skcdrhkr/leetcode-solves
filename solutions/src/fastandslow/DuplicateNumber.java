package fastandslow;

/**
 * Problem URL: https://leetcode.com/problems/find-the-duplicate-number/description/
 * Educative: https://www.educative.io/courses/grokking-coding-interview/find-the-duplicate-number
 * Level: Medium
 */

public class DuplicateNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(DuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));

        // Case 2
        System.out.println(DuplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));

        // Case 3
        System.out.println(DuplicateNumber.findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
