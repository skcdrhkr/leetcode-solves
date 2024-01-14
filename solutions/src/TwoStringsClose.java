import java.util.HashMap;

/**
 * Problem URL: https://leetcode.com/problems/determine-if-two-strings-are-close/description
 * Level: Medium
 */

public class TwoStringsClose {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TwoStringsClose.closeStrings("abc", "bca"));

        // Case 2
        System.out.println(TwoStringsClose.closeStrings("a", "aa"));

        // Case 3
        System.out.println(TwoStringsClose.closeStrings("cabbba", "abbccc"));

        // Case 4
        System.out.println(TwoStringsClose.closeStrings("ccabaabccccba", "ccccaaabbbcab"));
    }

    public static boolean closeStrings(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n != m)
            return false;
        int[] freqa = new int[26];
        int[] freqb = new int[26];
        for (char c : word1.toCharArray()) {
            freqa[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freqb[c - 'a']++;
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (freqa[i] == 0 && freqb[i] != 0)
                return false;
            if (freqa[i] != 0 && freqb[i] == 0)
                return false;
            if (freqa[i] != 0 && freqb[i] != 0) {
                int temp = mp.getOrDefault(freqa[i], 0);
                mp.put(freqa[i], temp + 1);
                temp = mp.getOrDefault(freqb[i], 0);
                mp.put(freqb[i], temp - 1);
            }
        }
        for (int val : mp.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
}
