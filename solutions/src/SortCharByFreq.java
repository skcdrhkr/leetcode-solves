import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem URL: https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Level: Medium
 */

public class SortCharByFreq {

    public static void main(String[] args) {
        // Case 1
        System.out.println(SortCharByFreq.frequencySort("tree"));

        // Case 2
        System.out.println(SortCharByFreq.frequencySort("cccaaa"));

        // Case 3
        System.out.println(SortCharByFreq.frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .map(x -> getCountedChar(x.getKey(), x.getValue())).collect(Collectors.joining());
    }

    private static String getCountedChar(Character x, Long y) {
        return String.join("", Collections.nCopies(y.intValue(), String.valueOf(x)));
    }
}
