import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/move-zeroes/description/
 * Level: Easy
 */

public class MoveZeroes {

    public static void main(String[] args) {
        // Case 1
        int[] case1 = new int[]{0, 1, 0, 3, 12};
        MoveZeroes.moveZeroes(case1);
        System.out.println(Arrays.toString(case1));

        // Case 2
        int[] case2 = new int[]{0};
        MoveZeroes.moveZeroes(case2);
        System.out.println(Arrays.toString(case2));

        // Case 3
        int[] case3 = new int[]{-1, 0, 2, 3, 40, 0, 2, 0, -1};
        MoveZeroes.moveZeroes(case3);
        System.out.println(Arrays.toString(case3));
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int z = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                nums[z++] = nums[i];
        }
        while (z < n)
            nums[z++] = 0;
    }
}
