import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayElementOccurences {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(ArrayElementOccurences.occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1)));

        // Case 2
        System.out.println(Arrays.toString(ArrayElementOccurences.occurrencesOfElement(new int[]{1, 2, 3}, new int[]{10}, 5)));

        // Case 3
        System.out.println(Arrays.toString(ArrayElementOccurences.occurrencesOfElement(new int[]{4, 5, 3, 2, 5, 6, 5, 4, 5, 5}, new int[]{8, 4, 3, 5, 1, 9, 2}, 5)));
    }

    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int len = nums.length;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == x) {
                index.add(i);
            }
        }
        int qLen = queries.length;
        int[] res = new int[qLen];
        int resI = 0;
        int ind = 0;
        for (int i = 0; i < qLen; i++) {
            if (queries[i] > index.size()) res[resI++] = -1;
            else {
                res[resI++] = index.get(queries[i] - 1);
            }
        }
        return res;
    }
}
