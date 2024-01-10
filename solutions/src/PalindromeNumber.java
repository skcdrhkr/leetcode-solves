/**
 * Problem URL: https://leetcode.com/problems/palindrome-number/description/
 * Level: Easy
 */

public class PalindromeNumber {
    public static void main(String[] args) {
        // Case 1
        System.out.println(PalindromeNumber.isPalindrome(121));

        // Case 2
        System.out.println(PalindromeNumber.isPalindrome(-121));

        //Case3
        System.out.println(PalindromeNumber.isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x == 0)
            return true;
        int nw = 0, cur = x;
        while (cur > 0) {
            nw = (nw * 10) + (cur % 10);
            cur /= 10;
        }
        return nw == x;
    }
}
