import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/
 * Level: Easy
 */

public class SubstringTwoEqualCharacters {
    public static void main(String[] args) {
        // Case 1
        System.out.println(SubstringTwoEqualCharacters.maxLengthBetweenEqualCharacters("aa"));
        // Case 2
        System.out.println(SubstringTwoEqualCharacters.maxLengthBetweenEqualCharacters("abca"));
        // Case 3
        System.out.println(SubstringTwoEqualCharacters.maxLengthBetweenEqualCharacters("cbzxy"));
        // Case 4
        System.out.println(SubstringTwoEqualCharacters.maxLengthBetweenEqualCharacters("abrakadla"));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] mp = new int[26];
        Arrays.fill(mp, -1);
        int mx = -2;
        for (int i = 0; i < s.length(); i++) {
            if (mp[s.charAt(i) - 'a'] == -1) {
                mp[s.charAt(i) - 'a'] = i;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = mp[s.charAt(i) - 'a'];
            if (val != -1) {
                if (mx < (i - val)) {
                    mx = i - val - 1;
                }
            }
        }
        return mx;
    }
}
