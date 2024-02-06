/**
 * Problem URL: https://leetcode.com/problems/first-unique-character-in-a-string/description
 * Level: Easy
 */

import java.util.Arrays;

public class FirstUniqueChar {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FirstUniqueChar.firstUniqChar("leetcode"));

        // Case 2
        System.out.println(FirstUniqueChar.firstUniqChar("loveleetcode"));

        // Case 3
        System.out.println(FirstUniqueChar.firstUniqChar("aabb"));
    }

    public static int firstUniqChar(String s) {
        int n = s.length();
        if (n == 1)
            return 0;
        int[] freq = new int[26];
        Arrays.fill(freq, -1);
        byte[] sb = s.getBytes();
        for (int i = 0; i < n; i++) {
            if (freq[sb[i] - 'a'] == -1) {
                freq[sb[i] - 'a'] = i;

            } else {
                freq[sb[i] - 'a'] = -2;
            }
        }
        int mn = n + 1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != -2 && freq[i] != -1) {
                if (mn > freq[i])
                    mn = freq[i];
            }
        }
        return mn==n+1?-1:mn;
    }
}
