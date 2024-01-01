import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem URL: https://leetcode.com/problems/two-sum/description/
 * Level: Easy
 */

public class TwoSum {
    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        // Case 2
        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{3, 2, 4}, 6)));
        // Case 3
        System.out.println(Arrays.toString(TwoSum.twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(target - nums[i])) {
                return new int[]{i, mp.get(target - nums[i])};
            }
            mp.put(nums[i], i);
        }
        return new int[]{};
    }
}
