import java.util.ArrayList;
import java.util.List;

/**
 * Problem URL: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/
 * Level: Medium
 */

public class ArrayTo2D {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ArrayTo2D.findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        // Case 2
        System.out.println(ArrayTo2D.findMatrix(new int[]{1, 2, 3, 4}));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] freq = new int[n + 1];
        for (int num : nums) {
            freq[num]++;
            if (res.size() < freq[num])
                res.add(new ArrayList<>());
            res.get(freq[num] - 1).add(num);
        }
        return res;
    }
}
