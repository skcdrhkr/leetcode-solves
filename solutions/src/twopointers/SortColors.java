/**
 * Educative: https://www.educative.io/courses/grokking-coding-interview/sort-colors
 */

package twopointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(SortColors.sortColors(new int[]{0, 1, 0})));

        // Case 2
        System.out.println(Arrays.toString(SortColors.sortColors(new int[]{1})));

        // Case 3
        System.out.println(Arrays.toString(SortColors.sortColors(new int[]{2, 2})));

        // Case 4
        System.out.println(Arrays.toString(SortColors.sortColors(new int[]{2, 1, 1, 0, 0})));
    }

    public static int[] sortColors(int[] colors) {

        int len = colors.length;
        int zeroes = 0, ones = 0, twos = len - 1;
        while (ones <= twos) {
            if (colors[ones] == 0) {
                colors[ones] = colors[zeroes];
                colors[zeroes] = 0;
                ones++;
                zeroes++;
            } else if (colors[ones] == 1) {
                ones++;
            } else {
                colors[ones] = colors[twos];
                colors[twos] = 2;
                twos--;
            }
        }
        return colors;
    }
}
