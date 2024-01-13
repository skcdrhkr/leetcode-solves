/**
 * Problem URL: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description
 * Level: Medium
 */

public class MakeStringsAnagram {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MakeStringsAnagram.minSteps("bab", "aba"));

        // Case 2
        System.out.println(MakeStringsAnagram.minSteps("leetcode", "practice"));

        // Case 3
        System.out.println(MakeStringsAnagram.minSteps("anagram", "mangaar"));
    }

    public static int minSteps(String s, String t) {
        int[] freq = new int[26];
        byte[] sbytes = s.getBytes();
        byte[] tbytes = t.getBytes();

        for (byte c : sbytes) {
            freq[c - 'a'] += 1;
        }
        for (byte c : tbytes) {
            freq[c - 'a'] -= 1;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += (Math.abs(freq[i]));
        }
        return res / 2;
    }
}
