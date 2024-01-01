import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/assign-cookies/description
 * Level: Easy
 */
public class AssignCookies {
    public static void main(String[] args) {
        // Case 1
        System.out.println(AssignCookies.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        // Case 2
        System.out.println(AssignCookies.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        if (m == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0, i = 0, j = 0;
        while (j < m && i < n) {
            if (s[j] >= g[i]) {
                j++;
                i++;
                res++;
            } else {
                j++;
            }
        }

        return res;
    }
}
