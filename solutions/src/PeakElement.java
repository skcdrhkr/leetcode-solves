/**
 * Problem URL: https://leetcode.com/problems/find-peak-element/description/
 * Level: Medium
 */

public class PeakElement {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PeakElement.findPeakElement(new int[]{1, 2, 3, 1}));

        // Case 2
        System.out.println(PeakElement.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));

        // Case 3
        System.out.println(PeakElement.findPeakElement(new int[]{1, 2, 3, 5, 6, 8, 9, 10}));

        // Case 4
        System.out.println(PeakElement.findPeakElement(new int[]{10, 4, 3, 1, 0, 2, 6}));
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int lo = 0, hi = n - 1, mid;
        int lft, rt;
        while (lo <= hi) {
            mid = (lo + hi + 1) / 2;
            lft = mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE;
            rt = mid < n - 1 ? nums[mid + 1] : Integer.MIN_VALUE;
            if (lft < nums[mid] && rt < nums[mid]) return mid;
            if (lft < nums[mid])
                lo = mid;
            else
                hi = mid - 1;
        }
        return -1;
    }
}
