/**
 * Problem URL: https://leetcode.com/problems/n-th-tribonacci-number/description/
 * Level: Easy
 */

public class TribonacciNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(TribonacciNumber.tribonacci(4));

        // Case 2
        System.out.println(TribonacciNumber.tribonacci(25));
    }

    public static int tribonacci(int n) {
        if (n <= 1)
            return n;
        if (n == 2)
            return 1;
        int first = 0, second = 1, third = 1, temp;
        for (int i = 3; i <= n; i++) {
            temp = first + second + third;
            first = second;
            second = third;
            third = temp;
        }
        return third;
    }
}
