/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/minimum-number-of-moves-to-make-palindrome
 * Leetcode: https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/description/
 */

package twopointers;

public class MinimumMovesToMakePalindrome {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MinimumMovesToMakePalindrome.minMovesToMakePalindrome("ccxx"));

        // Case 2
        System.out.println(MinimumMovesToMakePalindrome.minMovesToMakePalindrome("arcacer"));

        // Case 3
        System.out.println(MinimumMovesToMakePalindrome.minMovesToMakePalindrome("eggeekgbbeg"));

        // Case 4
        System.out.println(MinimumMovesToMakePalindrome.minMovesToMakePalindrome("ooooooooo"));
    }

    public static int minMovesToMakePalindromeEducative(String s) {
        char[] chars = s.toCharArray();

        int moves = 0;

        for (int i = 0, j = chars.length - 1; i < j; ++i) {
            int k = j;
            for (; k > i; --k) {
                if (chars[i] == chars[k]) {
                    for (; k < j; ++k) {
                        char temp = chars[k];
                        chars[k] = chars[k + 1];
                        chars[k + 1] = temp;
                        ++moves;
                    }
                    --j;
                    break;
                }
            }
            if (k == i) {
                moves += chars.length / 2 - i;
            }
        }
        return moves;
    }

    public static int minMovesToMakePalindrome(String s) {
        char[] string = s.toCharArray();
        int len = string.length;
        int left = 0, right = len - 1, mid;
        int moves = 0;
        char temp;
        for (left = 0; left < right; left++) {
            mid = right;
            while (mid > left && string[left] != string[mid]) {
                mid--;
            }
            if (mid != left) {
                while (mid < right) {
                    temp = string[mid];
                    string[mid] = string[mid + 1];
                    string[mid + 1] = temp;
                    mid++;
                    moves++;
                }
                right--;
            } else {
                moves += (len / 2 - left);
            }
        }
        return moves;

    }
}
