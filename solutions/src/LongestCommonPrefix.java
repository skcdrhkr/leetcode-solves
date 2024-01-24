/**
 * Problem URL: https://leetcode.com/problems/longest-common-prefix/description/
 * Level: Easy
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        // Case 1
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

        // Case 2
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

        // Case 3
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1)
            return strs[0];
        byte[] res = strs[0].getBytes();
        if (res.length == 0)
            return "";
        int ind = 1, fin = 0, mx = res.length;
        while (ind < n) {
            byte[] cur = strs[ind].getBytes();
            for (fin = 0; fin < mx && fin < cur.length; ) {
                if (res[fin] == cur[fin]) {
                    fin += 1;
                } else {
                    break;
                }
            }
            if (mx > fin)
                mx = fin;
            if (mx == 0)
                return "";
            ind += 1;
        }
        return new String(res, 0, mx);
    }
}
