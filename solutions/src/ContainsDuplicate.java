import java.util.HashSet;

/**
 * Problem URL: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 * Level: Easy
 */

public class ContainsDuplicate {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}));

        // Case 2
        System.out.println(ContainsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}));

        // Case 3
        System.out.println(ContainsDuplicate.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
