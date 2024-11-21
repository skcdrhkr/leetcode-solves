/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/3sum
 */

package twopointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ValidPalindrome.isPalindrome("kaYak"));

        // Case 2
        System.out.println(ValidPalindrome.isPalindrome("hello"));
    }

    public static boolean isPalindrome(String s) {
        int first = 0, last = s.length() - 1;
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
}
