import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/squares-of-a-sorted-array/description
 * Level: Easy
 */

public class SquaresSortedArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(SquaresSortedArray.sortedSquares(new int[]{-4, -1, 0, 3, 10})));

        // Case 2
        System.out.println(Arrays.toString(SquaresSortedArray.sortedSquares(new int[]{-7, -3, 2, 3, 11})));

        // Case 3
        System.out.println(Arrays.toString(SquaresSortedArray.sortedSquares(new int[]{-4, -2})));

        // Case 4
        System.out.println(Arrays.toString(SquaresSortedArray.sortedSquares(new int[]{4, 5})));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int[] res = new int[n];
        int negnum;
        int posnum;
        int i = n - 1;
        while (i >= 0) {
            negnum = Math.abs(nums[left]);
            posnum = Math.abs(nums[right]);
            if (negnum > posnum) {
                res[i--] = negnum * negnum;
                left++;
            } else {
                res[i--] = posnum * posnum;
                right--;
            }
        }
        return res;
    }
}
