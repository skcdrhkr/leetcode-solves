package subsets;

import java.util.ArrayList;
import java.util.List;

public class KSumSubset {

    public static void main(String[] args) {
        // Case 1
        System.out.println(KSumSubset.getKSumSubsets(new int[]{8, 13, 3, 22, 17, 39, 87, 45, 36}, 3));

        // Case 2
        System.out.println(KSumSubset.getKSumSubsets(new int[]{8, 13, 3, 22, 17, 39, 87, 45, 36}, 135));

        // Case 3
        System.out.println(KSumSubset.getKSumSubsets(new int[]{8, 13, 3, 22, 17, 39, 87, 45, 36}, 47));
    }

    public static List<List<Integer>> getKSumSubsets(int[] nums, int k) {
        // Replace this placeholder return statement with your code
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        getAllKSumSubsets(nums, len, k, result, 0, new ArrayList<>());

        return result;
    }

    private static void getAllKSumSubsets(int[] nums, int len, int k, List<List<Integer>> result, int ind, ArrayList<Integer> current) {
        if (ind >= len) {
            if (k == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        getAllKSumSubsets(nums, len, k, result, ind + 1, current);
        if (nums[ind] <= k) {
            current.add(nums[ind]);
            getAllKSumSubsets(nums, len, k - nums[ind], result, ind + 1, current);
            current.remove(Integer.valueOf(nums[ind]));
        }
    }
}
