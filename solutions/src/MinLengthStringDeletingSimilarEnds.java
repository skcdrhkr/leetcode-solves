/**
 * Problem URL: https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description
 * Level: Medium
 */

public class MinLengthStringDeletingSimilarEnds {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinLengthStringDeletingSimilarEnds.minimumLength("ca"));

        // Case 2
        System.out.println(MinLengthStringDeletingSimilarEnds.minimumLength("cabaabac"));

        // Case 3
        System.out.println(MinLengthStringDeletingSimilarEnds.minimumLength("aabccabba"));
    }

    public static int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int first = 0, second = n - 1;
        while (first < second) {
            if (chars[first] != chars[second])
                break;
            first++;
            second -= 1;
            while (first <= second && chars[first] == chars[first - 1]) first++;
            while (first <= second && chars[second] == chars[second + 1]) second--;
        }
        if (second < first) return 0;
        return second - first + 1;
    }
}
