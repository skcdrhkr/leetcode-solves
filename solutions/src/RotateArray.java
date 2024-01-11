import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem URL: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 * Level: Medium
 */

public class RotateArray {

    public static void main(String[] args) {
        // Case 1
        int[] case1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        RotateArray.rotate(case1, 3);
        System.out.println(IntStream.of(case1).mapToObj(Integer::toString).collect(Collectors.joining(",")));

        // Case 2
        int[] case2 = new int[]{-1, -100, 3, 99};
        RotateArray.rotate(case2, 2);
        System.out.println(IntStream.of(case2).mapToObj(Integer::toString).collect(Collectors.joining(",")));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    static void reverse(int[] nums, int st, int end) {
        int temp;
        while (st < end) {
            temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st += 1;
            end -= 1;
        }
    }
}
