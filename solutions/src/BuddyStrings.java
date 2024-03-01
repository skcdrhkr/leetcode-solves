/**
 * Online Assessment Leetcode
 */

public class BuddyStrings {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BuddyStrings.buddyStrings("ab", "ba"));

        // Case 2
        System.out.println(BuddyStrings.buddyStrings("ab", "ab"));

        // Case 3
        System.out.println(BuddyStrings.buddyStrings("aa", "aa"));
    }

    public static boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m)
            return false;

        if (s.equals(goal)) {
            return handleSame(s, goal);
        }

        char a, b;
        int diff = 0;
        char p = '!', q = '!';
        for (int i = 0; i < n; i++) {
            a = s.charAt(i);
            b = goal.charAt(i);
            if (a == b) {
                continue;
            }
            if (diff > 1)
                return false;
            if (diff == 0) {
                p = a;
                q = b;
                diff++;
            } else {
                if (a != q || b != p)
                    return false;
                diff++;
            }
        }
        if (diff == 1) return false;
        return true;
    }

    private static boolean handleSame(String s, String goal) {
        boolean[] freq = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'])
                return true;
            freq[s.charAt(i) - 'a'] = true;
        }
        return false;
    }
}
