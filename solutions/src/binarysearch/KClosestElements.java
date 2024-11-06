package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KClosestElements {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KClosestElements.findClosestElements(new int[]{1, 2, 2, 2, 5, 5, 5, 8, 9, 9}, 4, 0));

        // Case 2
        System.out.println(KClosestElements.findClosestElements(new int[]{1, 3}, 1, 2));

        // Case 3
        System.out.println(KClosestElements.findClosestElements(new int[]{-29, -11, -3, 0, 5, 10, 50, 63, 198}, 6, 8));
    }

    public static List<Integer> findClosestElements(int[] nums, int k, int target) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        if (len <= k) {
            for (int num : nums) {
                result.add(num);
            }
            return result;
        }
        if (nums[0] >= target) {
            for (int i = 0; i < k; i++) {
                result.add(nums[i]);
            }
            return result;
        }
        if (nums[len - 1] <= target) {
            for (int i = len - k; i < len; i++) {
                result.add(nums[i]);
            }
            return result;
        }
        int leftWindow = searchBinary(nums, target) - 1;
        int rightWindow = leftWindow + 1;
        while ((rightWindow - leftWindow - 1) < k) {
            if (leftWindow == -1) {
                rightWindow++;
                continue;
            }
            if (rightWindow == len || Math.abs(nums[leftWindow] - target) <= Math.abs(nums[rightWindow] - target)) {
                leftWindow--;
            } else {
                rightWindow++;
            }
        }
        for (int i = leftWindow + 1; i < rightWindow; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    private static int searchBinary(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static List<Integer> findClosestElementsWithoutBinarySearch(int[] nums, int k, int target) {
        int len = nums.length;
        Integer[][] distance = new Integer[len][2];
        for (int i = 0; i < len; i++) {
            distance[i][0] = Math.abs(target - nums[i]);
            distance[i][1] = nums[i];
        }
        Arrays.sort(distance, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(distance[i][1]);
        }
        Collections.sort(result);
        return result;
    }
}
