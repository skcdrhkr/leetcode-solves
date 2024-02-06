import java.util.Arrays;

public class MergeSorted {

    public static void main(String[] args) {
        // Case 1
        int[] arr1 = new int[]{1, 2, 3, 0, 0, 0};
        MergeSorted.merge(arr1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int st = n + m - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[st--] = nums2[j--];
                continue;
            }
            if (j == -1) {
                nums1[st--] = nums1[i--];
                continue;
            }
            if (nums1[i] < nums2[j]) {
                nums1[st--] = nums2[j--];
            } else {
                nums1[st--] = nums1[i--];
            }
        }
    }
}
