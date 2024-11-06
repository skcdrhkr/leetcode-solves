package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BinarySearch.binarySearch(new int[]{11, 22, 33, 44, 55, 66, 77}, 33));

        // Case 2
        System.out.println(BinarySearch.binarySearch(new int[]{-3, -1, 0, 11, 15}, 0));
    }

    public static int binarySearch(int[] nums, int target) {
        int len = nums.length;
        int lo = 0, hi = len - 1, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}
