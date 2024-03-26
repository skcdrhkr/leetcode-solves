/**
 * Problem URL: https://leetcode.com/problems/first-missing-positive/description/
 * Level: Hard
 */

public class FirstMissingPositive {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{1, 2, 0}));

        // Case 2
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{3, 4, -1, 1}));

        // Case 3
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));

        // Case 4
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{5, 4, 0, 2, 0, 0, 1, 0, -4, 3}));

        // Case 5
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{1, 2, 0, 3, 0, 0, 5, 0, -4, 3}));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int cur, mx = (len + 2);
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) nums[i] = mx;
        }

        for (int i = 0; i < len; i++) {
            cur = nums[i];
            if (cur < 0) cur *= -1;
            if (cur > 0 && cur <= len && nums[cur - 1] > 0) {
                nums[cur - 1] *= -1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return len + 1;
    }
}
