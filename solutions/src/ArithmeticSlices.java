/**
 * Problem URL: https://leetcode.com/problems/arithmetic-slices/description/
 * Level: Medium
 */
public class ArithmeticSlices {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ArithmeticSlices.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        // Case 2
        System.out.println(ArithmeticSlices.numberOfArithmeticSlices(new int[]{1}));

    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return 0;
        int res = 0, curdiff = nums[1] - nums[0], cur = 2;
        for (int i = 2; i < n; i++) {
            if ((nums[i] - nums[i - 1]) == curdiff) {
                cur += 1;
            } else {
                cur -= 2;
                res += ((cur * (cur + 1)) / 2);
                cur = 2;
                curdiff = nums[i] - nums[i - 1];
            }
        }
        if (cur != 2) {
            cur -= 2;
            res += ((cur * (cur + 1)) / 2);
        }
        return res;
    }
}
