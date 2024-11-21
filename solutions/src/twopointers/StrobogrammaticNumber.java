/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/strobogrammatic-number
 */
package twopointers;

import java.util.Map;
import java.util.Set;

public class StrobogrammaticNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(StrobogrammaticNumber.isStrobogrammatic("818"));

        // Case 2
        System.out.println(StrobogrammaticNumber.isStrobogrammatic("962"));

        // Case 3
        System.out.println(StrobogrammaticNumber.isStrobogrammatic("619"));
    }

    public static boolean isStrobogrammaticBetter(String num) {
        Map<Character, Character> strobDigits = Map.of(
                '1', '1',
                '6', '9',
                '8', '8',
                '9', '6',
                '0', '0'
        );
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!strobDigits.containsKey(num.charAt(left)) || (strobDigits.get(num.charAt(left)) != num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isStrobogrammatic(String num) {
        Set<Character> nonStrobDigits = Set.of('2', '3', '4', '5', '7');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (nonStrobDigits.contains(num.charAt(left)) || nonStrobDigits.contains(num.charAt(right))) {
                return false;
            }
            if (num.charAt(left) == '9' && num.charAt(right) != '6') return false;
            if (num.charAt(left) == '6' && num.charAt(right) != '9') return false;
            left++;
            right--;
        }
        return true;
    }
}
