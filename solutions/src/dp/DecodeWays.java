package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeWays {

    private static HashSet<Integer> codes;

    public static void main(String[] args) {
        // Case 1
        System.out.println(DecodeWays.numOfDecodings("124"));

        // Case 2
        System.out.println(DecodeWays.numOfDecodings("11344"));

        // Case 3
        System.out.println(DecodeWays.numOfDecodings("1003"));

        // Case 4
        System.out.println(DecodeWays.numOfDecodings("227"));
    }

    private static int numOfDecodings(String decodeStr) {
        return 0;
    }

    public static int numOfDecodingsTopDown(String decodeStr) {
        Set<String> dict = IntStream.range(1, 27).boxed().map(x -> Integer.toString(x)).collect(Collectors.toSet());
        int[] memo = new int[decodeStr.length() + 1];
        Arrays.fill(memo, -1);
        return waysOfDecododings(decodeStr, dict, 0, decodeStr.length(), memo);
    }

    private static int waysOfDecododings(String decodeStr, Set<String> dict, int index, int length, int[] memo) {
        if (index >= length) {
            return 1;
        }
        if (memo[index] != -1) return memo[index];
        int ways = 0;
        String cur = decodeStr.substring(index, index + 1);
        if (dict.contains(cur)) {
            ways += waysOfDecododings(decodeStr, dict, index + 1, length, memo);
        }
        if (index < length - 1) {
            cur = decodeStr.substring(index, index + 2);
            if (dict.contains(cur)) {
                ways += waysOfDecododings(decodeStr, dict, index + 2, length, memo);
            }
        }
        memo[index] = ways;
        return ways;
    }

}
