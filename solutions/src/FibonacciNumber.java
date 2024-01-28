/**
 * Problem URL: https://leetcode.com/problems/fibonacci-number/description/
 * Level: Easy
 */

public class FibonacciNumber {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FibonacciNumber.fib(2));

        // Case 2
        System.out.println(FibonacciNumber.fib(3));
    }

    public static int fib(int n) {
        int i = 2;
        int first = 0, second = 1, temp;
        if (n <= 1)
            return n;
        while (i <= n) {
            temp = first + second;
            first = second;
            second = temp;
            i+=1;
        }
        return second;
    }
}
