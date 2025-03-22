package twopointers;

public class ValidPalindromeII {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ValidPalindromeII.isPalindrome("madame"));

        // Case 2
        System.out.println(ValidPalindromeII.isPalindrome("dead"));

        // Case 3
        System.out.println(ValidPalindromeII.isPalindrome("abca"));

        // Case 4
        System.out.println(ValidPalindromeII.isPalindrome("racecar"));
    }

    public static boolean isPalindrome(String string) {
        int first = 0, last = string.length() - 1;
        while (first < last) {
            if (string.charAt(first) != string.charAt(last)) {
                return isPalindrome(string, first + 1, last) || isPalindrome(string, first, last - 1);
            }
            first += 1;
            last -= 1;
        }
        return true;
    }

    private static boolean isPalindrome(String string, int first, int last) {
        while (first < last) {
            if (string.charAt(first) != string.charAt(last)) return false;
            first += 1;
            last -= 1;
        }
        return true;
    }
}
