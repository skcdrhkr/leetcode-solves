package binarysearch;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SingleElementInSortedArray.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 8, 8}));

        // Case 2
        System.out.println(SingleElementInSortedArray.singleNonDuplicate(new int[]{1, 1, 4, 4, 7, 7, 10, 10, 13, 13, 16, 16, 19, 19, 22, 22, 25}));

        // Case 3
        System.out.println(SingleElementInSortedArray.singleNonDuplicate(new int[]{1}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int lo = 0, hi = len - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi + 1) / 2;
            if (mid == 0 && nums[mid + 1] != nums[mid]) return nums[mid];
            if (mid == len - 1 && nums[mid - 1] != nums[mid]) return nums[mid];
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];
            if (nums[mid] != nums[mid + 1]) {

            } else {

            }
        }
        return nums[lo];
    }
}
