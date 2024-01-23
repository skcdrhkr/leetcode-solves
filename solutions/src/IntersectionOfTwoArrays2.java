import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 * Level: Easy
 */

public class IntersectionOfTwoArrays2 {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(IntersectionOfTwoArrays2.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

        // Case 2
        System.out.println(Arrays.toString(IntersectionOfTwoArrays2.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] freq = new int[1001];
        int ns = Math.max(n, m);
        int[] res = new int[ns];
        ns = 0;
        for (int j : nums1) {
            freq[j] += 1;
        }
        for (int j : nums2) {
            if (freq[j] > 0) {
                res[ns++] = j;
                freq[j]--;
            }
        }
        return Arrays.copyOf(res, ns);
    }
}
