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
        int res = 0;
        int n = height.length;
        int i = 0, j = n - 1, cur, min;
        while (i < j) {
            min = Math.min(height[i], height[j]);
            cur = (j - i) * min;
            if (cur > res)
                res = cur;
            if (min == height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
