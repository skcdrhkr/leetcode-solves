import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem URL: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description
 * Level: Medium
 */

public class LeastNumberUniqueIntegers {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LeastNumberUniqueIntegers.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));

        // Case 2
        System.out.println(LeastNumberUniqueIntegers.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        if (k >= n)
            return 0;
        List<Integer> sorted = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((x1, x2) -> x1.getValue().compareTo(x2.getValue()))
                .map(x -> getRepeatedNum(x.getKey(), x.getValue())).flatMap(List::stream).collect(Collectors.toList());
        int distinct = 1;
        for (int i = k + 1; i < n; i++) {
            if (!sorted.get(i).equals(sorted.get(i - 1)))
                distinct += 1;
        }
        return distinct;
    }

    private static List<Integer> getRepeatedNum(Integer key, Long value) {
        ArrayList<Integer> res = new ArrayList<>();
        while (value > 0) {
            res.add(key);
            value -= 1;
        }
        return res;
    }
}
