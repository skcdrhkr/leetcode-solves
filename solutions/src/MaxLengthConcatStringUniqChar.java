/**
 * Problem URL: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
 * Level: Medium
 */

import java.util.HashSet;
import java.util.List;

public class MaxLengthConcatStringUniqChar {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaxLengthConcatStringUniqChar.maxLength(List.of("un", "iq", "ue")));

        // Case 2
        System.out.println(MaxLengthConcatStringUniqChar.maxLength(List.of("cha", "r", "act", "ers")));

        // Case 3
        System.out.println(MaxLengthConcatStringUniqChar.maxLength(List.of("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn", "nm", "op", "po")));
    }

    public static int maxLength(List<String> arr) {
        int n = arr.size();
        int mask;
        int res = 0;
        int comb = (1 << (n)) - 1;
        HashSet<Integer> bad = new HashSet<>();
        for (int k = 1; k <= comb; k++) {
            mask = 0;
            int val = k;
            int ind = n - 1;
            int siz = 0;
            for (int num : bad) {
                int cur = num & k;
                if ((cur & (cur - 1)) != 0) {
                    val = 0;
                    break;
                }
            }
            while (val > 0) {
                if ((val & 1) != 0) {
                    for (byte c : arr.get(ind).getBytes()) {
                        if ((mask & (1 << (c - 'a'))) != 0) {
                            siz = 0;
                            bad.add(k);
                            break;
                        } else {
                            mask |= (1 << (c - 'a'));
                            siz += 1;
                        }
                    }
                }
                ind -= 1;
                val >>= 1;
            }
            if (res < siz)
                res = siz;
        }
        return res;
    }
}
