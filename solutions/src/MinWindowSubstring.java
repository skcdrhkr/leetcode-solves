/**
 * Problem URL: https://leetcode.com/problems/minimum-window-substring/description
 * Level: Hard
 */

public class MinWindowSubstring {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));

        // Case 2
        System.out.println(MinWindowSubstring.minWindow("a", "a"));

        // Case 3
        System.out.println(MinWindowSubstring.minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n)
            return "";
        int[] tf = new int[52];
        int[] sf = new int[52];
        int uniq = 0;
        for (byte k : t.getBytes()) {
            int ind;
            if (k >= 'A' && k <= 'Z') {
                ind = k - 'A';
            } else {
                ind = k - 'a' + 26;
            }
            if (tf[ind] == 0) {
                uniq += 1;
            }
            tf[ind] += 1;
        }
        int st = 0, en = 0, cuniq = 0, mn = Integer.MAX_VALUE, first = -1, last = -1;
        while (en < n) {
            int ind;
            char k = s.charAt(en);
            if (k >= 'A' && k <= 'Z') {
                ind = k - 'A';
            } else {
                ind = k - 'a' + 26;
            }
            sf[ind] += 1;
            if (sf[ind] == tf[ind]) {
                cuniq += 1;
            }
            if (cuniq == uniq) {
                if (mn > (en - st + 1)) {
                    mn = en - st + 1;
                    last = en;
                    first = st;
                }
                while (st <= en) {
                    k = s.charAt(st);
                    if (k >= 'A' && k <= 'Z') {
                        ind = k - 'A';
                    } else {
                        ind = k - 'a' + 26;
                    }
                    if (tf[ind] == 0)
                        st += 1;
                    else {
                        if (cuniq == uniq) {
                            if (mn > (en - st + 1)) {
                                last = en;
                                first = st;
                                mn = en - st + 1;
                            }
                        }
                        if (cuniq < uniq)
                            break;
                        sf[ind] -= 1;
                        if (tf[ind] > sf[ind]) {
                            cuniq -= 1;
                        }
                        st += 1;
                    }
                }
            }
            en += 1;
        }
        if (first == -1)
            return "";
        else
            return s.substring(first, last + 1);
    }
}
