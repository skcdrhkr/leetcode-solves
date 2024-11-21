package kwaymerge;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        // Case 1
        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        MergeArray.mergeSorted(arr1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int ind = n + m - 1;
        int first = m - 1, second = n - 1;
        while (ind >= 0) {
            if (first < 0) {
                nums1[ind--] = nums2[second--];
            } else if (second < 0) {
                nums1[ind--] = nums1[first--];
            } else if (nums1[first] > nums2[second]) {
                nums1[ind--] = nums1[first--];
            } else {
                nums1[ind--] = nums2[second--];
            }
        }
        return nums1;
    }
}
