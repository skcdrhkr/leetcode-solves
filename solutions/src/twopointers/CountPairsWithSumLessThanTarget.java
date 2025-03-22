package twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPairsWithSumLessThanTarget {
    public static void main(String[] args) {
        // Case 1
        System.out.println(CountPairsWithSumLessThanTarget.countPairs(Arrays.asList(-5, 0, -7, -1, 9, 8, -9, 9), -14));
        // Case 2
        System.out.println(CountPairsWithSumLessThanTarget.countPairs(Arrays.asList(-6, 2, 5, -2, -7, -1, 3), -2));
    }

    public static int countPairs(List<Integer> nums, int target) {
        int len = nums.size();
        int result = 0;
        Collections.sort(nums);
        int second = len - 1, first = 0;
        while (first < second) {
            if (nums.get(first) + nums.get(second) < target) {
                result += (second - first);
                first++;
            } else {
                second -= 1;
            }
        }
        return result;
    }
}
