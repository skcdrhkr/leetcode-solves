package subsets;

import java.util.ArrayList;
import java.util.List;

public class FindSubsets {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FindSubsets.findAllSubsets(new int[]{1}));

        // Case 2
        System.out.println(FindSubsets.findAllSubsets(new int[]{2, 5, 7}));

        // Case 3
        System.out.println(FindSubsets.findAllSubsets(new int[]{1, 2, 3, 4}));
    }

    private static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return setsList;
        }
        int resultSize = (int) Math.pow(2, len);
        for (int i = 0; i < resultSize; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                boolean bitSet = getBit(i, j);
                if (bitSet) {
                    current.add(nums[j]);
                }
            }
            setsList.add(current);
        }

        return setsList;
    }

    private static boolean getBit(int i, int j) {
        int bit = 1 << j;
        return ((bit & i) != 0);
    }

    public static List<List<Integer>> findAllSubsetsBruteForce(int[] nums) {
        // Replace this placeholder return statement with your code

        List<List<Integer>> setsList = new ArrayList<>();
        getAllSubsets(nums, 0, setsList, new ArrayList<>());
        return setsList;
    }

    private static void getAllSubsets(int[] nums, int ind, List<List<Integer>> setsList, ArrayList<Integer> current) {
        if (ind >= nums.length) {
            setsList.add(new ArrayList<>(current));
            return;
        }
        getAllSubsets(nums, ind + 1, setsList, current);
        current.add(nums[ind]);
        getAllSubsets(nums, ind + 1, setsList, current);
        current.remove(Integer.valueOf(nums[ind]));
    }
}
