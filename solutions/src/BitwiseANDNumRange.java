/**
 * Problem URL: https://leetcode.com/problems/bitwise-and-of-numbers-range/description
 * Level: Medium
 */

public class BitwiseANDNumRange {

    public static void main(String[] args) {
        // Case 1
        System.out.println(BitwiseANDNumRange.rangeBitwiseAnd(5, 7));

        // Case 2
        System.out.println(BitwiseANDNumRange.rangeBitwiseAnd(0, 0));

        // Case 3
        System.out.println(BitwiseANDNumRange.rangeBitwiseAnd(1, 2147483647));

        // Case 4
        System.out.println(BitwiseANDNumRange.rangeBitwiseAnd(13, 15));

        System.out.println(BitwiseANDNumRange.rangeBitwiseAnd(3, 4));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count += 1;
        }
        return left <<= count;
    }
}
