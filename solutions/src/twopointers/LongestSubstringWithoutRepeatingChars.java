package twopointers;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("abcabcbb"));

        // Case 2
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("bbbbb"));

        // Case 3
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("pwwkew"));

        // Case 4
        System.out.println(LongestSubstringWithoutRepeatingChars.lengthOfLongestSubstring("abcdecabfgaf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int result = 0;
        int left = 0, right = 0;
        while (right < len) {
            int ch = s.charAt(right);
            if (hash[ch] != -1 && left <= hash[ch]) {
                left = hash[ch] + 1;
            }
            result = Math.max(right - left + 1, result);
            hash[ch] = right;
            right++;
        }
        return result;
    }
}
