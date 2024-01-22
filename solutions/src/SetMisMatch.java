import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/set-mismatch/description/
 * Level: Easy
 */

public class SetMisMatch {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(SetMisMatch.findErrorNums(new int[]{1, 2, 2, 4})));

        // Case 2
        System.out.println(Arrays.toString(SetMisMatch.findErrorNums(new int[]{1, 1})));
    }

    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] < 0) {
                res[0] = ind + 1;
            } else {
                nums[ind] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                return res;
            }
        }
        return res;
    }
}
