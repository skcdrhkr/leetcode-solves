import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem URL: https://leetcode.com/problems/majority-element/description/
 * Level: Easy
 */

public class MajorityElement {


    public static void main(String[] args) {
        // Case 1
        System.out.println(MajorityElement.majorityElement(new int[]{3, 2, 3}));

        // Case 2
        System.out.println(MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter((x) -> x.getValue() > nums.length / 2).findFirst().get().getKey();

    }
}
