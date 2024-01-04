import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-enumsty/description
 * Level: Medium
 */

public class MakeArrayEmpty {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MakeArrayEmpty.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        // Case 2
        System.out.println(MakeArrayEmpty.minOperations(new int[]{2, 1, 2, 2, 3, 3}));
    }

    public static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                count++;
            else {
                if (count == 1)
                    return -1;
                if (count % 3 == 0)
                    res += (count / 3);
                else {
                    res += ((count / 3) + 1);
                }
                count = 1;
            }
        }
        if (count == 1)
            return -1;
        if (count % 3 == 0)
            res += (count / 3);
        else {
            res += ((count / 3) + 1);
        }
        return res;
    }
}
