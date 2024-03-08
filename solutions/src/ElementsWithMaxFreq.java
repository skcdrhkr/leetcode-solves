import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ElementsWithMaxFreq {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ElementsWithMaxFreq.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));

        // Case 2
        System.out.println(ElementsWithMaxFreq.maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }

    public static int maxFrequencyElements(int[] nums) {
        Map.Entry<Long, Long> longLongEntry = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max((x,y)-> Math.toIntExact(x.getKey() - y.getKey())).get();
        return (int) (longLongEntry.getKey() * longLongEntry.getValue());
    }


}
