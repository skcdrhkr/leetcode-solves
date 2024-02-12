/**
 * Problem URL: https://leetcode.com/problems/palindromic-substrings/description
 * Level: Medium
 */

public class PalindromicSubstrings {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PalindromicSubstrings.countSubstrings("abc"));

        // Case 2
        System.out.println(PalindromicSubstrings.countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        byte[] sb = s.getBytes();
        int n = sb.length;
        if (n == 1)
            return 1;
        int res = 0, k, j;
        for (int i = 0; i < n; i++) {
            res += 1;
            j = i - 1;
            k = i + 1;
            while (j >= 0 && k <= n - 1 && sb[j] == sb[k]) {
                j--;
                k++;
                res += 1;
            }
            j = i - 1;
            k = i;
            while (j >= 0 && k <= n - 1 && sb[j] == sb[k]) {
                j--;
                k++;
                res += 1;
            }
        }
        return res;
    }
}
