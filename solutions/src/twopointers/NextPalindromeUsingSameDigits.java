/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/next-palindrome-using-same-digits
 * Leetcode: https://leetcode.com/problems/next-palindrome-using-same-digits/description/
 */
package twopointers;

public class NextPalindromeUsingSameDigits {

    public static void main(String[] args) {
        // Case 1
        System.out.println(NextPalindromeUsingSameDigits.findNextPalindrome("11"));

        // Case 2
        System.out.println(NextPalindromeUsingSameDigits.findNextPalindrome("12321"));

        // Case 3
        System.out.println(NextPalindromeUsingSameDigits.findNextPalindrome("23143034132"));

        // Case 4
        System.out.println(NextPalindromeUsingSameDigits.findNextPalindrome("1001"));
    }

    public static String findNextPalindrome(String numStr) {
        char[] nums = numStr.toCharArray();
        int len = nums.length;
        if (len <= 3) return "";
        int mid = (len / 2) - 1;
        int index = mid - 1;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index == -1) return "";
        int toSwap = index + 1, counter = toSwap;
        while (counter >= mid) {
            if (nums[counter] > nums[index] && nums[counter] < nums[toSwap]) {
                toSwap = counter;
            }
            counter--;
        }
        //todo Input toSwap character at index and shift all chars to right
        char temp = nums[index];
        nums[index] = nums[index + 1];
        nums[index + 1] = temp;
        int next;
        if ((len & 1) == 0) {
            next = mid + 1;
        } else {
            next = mid + 2;
        }
        while (mid >= 0) {
            nums[next] = nums[mid];
            mid--;
            next++;
        }
        return new String(nums);
    }
}
