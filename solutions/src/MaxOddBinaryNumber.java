/**
 * Problem URL: https://leetcode.com/problems/maximum-odd-binary-number/description
 * Level: Easy
 */

public class MaxOddBinaryNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MaxOddBinaryNumber.maximumOddBinaryNumber("010"));

        // Case 2
        System.out.println(MaxOddBinaryNumber.maximumOddBinaryNumber("0101"));

        // Case 3
        System.out.println(MaxOddBinaryNumber.maximumOddBinaryNumber("0011101100"));
    }

    public static String maximumOddBinaryNumber(String s) {
        int n = s.length();
        if (n == 1)
            return s;
        int ones = 0, ind = 0;
        char[] cs = s.toCharArray();
        while (ind < n - 1) {
            if (cs[ind] == '1') {
                if (cs[n - 1] == '1') {
                    cs[ind] = cs[ones];
                    cs[ones++] = '1';
                } else {
                    cs[n - 1] = '1';
                    cs[ind] = '0';
                }
            }
            ind++;
        }
        return new String(cs);
    }
}
