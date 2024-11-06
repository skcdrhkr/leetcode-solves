package binarysearch;

import java.util.List;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SearchInRotatedSortedArray.binarySearchRotated(List.of(6, 7, 1, 2, 3, 4, 5), 3));

        // Case 2
        System.out.println(SearchInRotatedSortedArray.binarySearchRotated(List.of(4, 5, 6, 1, 2, 3), 3));
    }

    public static int binarySearchRotated(List<Integer> nums, int target) {

        int len = nums.size();
        int lo = 0, hi = len - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums.get(mid) == target) return mid;
            if (nums.get(lo) < nums.get(mid)) {
                if (nums.get(lo) <= target && target < nums.get(mid)) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums.get(mid) < target && target <= nums.get(hi)) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
