package stacks;

/**
 * Problem URL: https://leetcode.com/problems/container-with-most-water/description/
 * Level: Medium
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ContainerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

        // Case 2
        System.out.println(ContainerWithMostWater.maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int result = 0;
        while (left < right) {
            int curH = Math.min(height[left], height[right]);
            result = Math.max(result, curH * (right - left));
            while (left < right && height[left] <= curH) {
                left++;
            }
            while (left < right && height[right] <= curH) {
                right--;
            }
        }
        return result;
    }
}
