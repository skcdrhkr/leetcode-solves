package twopointers;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctChars {
    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestSubstringWithAtMostKDistinctChars.kDistinctChars(6, "zcviqwyuydegijtgwxujqdn")); // 7

        // Case 2
        System.out.println(LongestSubstringWithAtMostKDistinctChars.kDistinctChars(3, "abcddefg")); // 4

        // Case 3
        System.out.println(LongestSubstringWithAtMostKDistinctChars.kDistinctChars(2, "eceba")); // 3

        // Case 4
        System.out.println(LongestSubstringWithAtMostKDistinctChars.kDistinctChars(1, "aa")); // 2

    }

    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int len = str.length();
        HashMap<Character, Integer> hash = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;

        while (right < len) {
            char ch = str.charAt(right);
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
            while (hash.size() > k) {
                char leftMost = str.charAt(left);
                hash.put(leftMost, hash.get(leftMost) - 1);
                if (hash.get(leftMost) == 0) {
                    hash.remove(leftMost);
                }
                left += 1;
            }
            result = Math.max(result, right - left + 1);
            right += 1;
        }
        return result;
    }
}
