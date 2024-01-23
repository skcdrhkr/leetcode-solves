import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/plus-one/description/
 * Level: Easy
 */

public class PlusOne {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[]{1, 2, 3})));

        // Case 2
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[]{4, 3, 2, 1})));

        // Case 3
        System.out.println(Arrays.toString(PlusOne.plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int car = 1;
        int i = n - 1;
        while (car > 0 && i >= 0) {
            digits[i] = digits[i] + car;
            car = digits[i] / 10;
            digits[i] %= 10;
            i--;
        }
        if (car == 0)
            return digits;
        int[] res = new int[n + 1];
        res[0] = car;
        for (i = 1; i < n; i++) {
            res[i] = digits[i];
        }
        return res;
    }
}
