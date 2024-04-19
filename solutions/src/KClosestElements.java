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
        if (len == 1) return List.of(nums[0]);
        List<Integer> result = new ArrayList<>();
        int[][] distances = new int[len][2];
        for (int i = 0; i < len; i++) {
            distances[i][0] = nums[i];
            distances[i][1] = Math.abs(target - nums[i]);
        }
        Arrays.sort(distances, (x, y) -> (x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]));
        for (int i = 0; i < k; i++) {
            result.add(distances[i][0]);
        }
        Collections.sort(result);
        return result;
    }
}
