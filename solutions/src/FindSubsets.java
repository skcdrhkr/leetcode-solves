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

    public static List<List<Integer>> findAllSubsets(int[] nums) {
        // Replace this placeholder return statement with your code

        List<List<Integer>> setsList = new ArrayList<>();
        getAllSubsets(nums, 0, setsList);
        return setsList;
    }

    private static void getAllSubsets(int[] nums, int ind, List<List<Integer>> setsList) {
        if (ind >= nums.length)
            return;
        setsList
    }
}
