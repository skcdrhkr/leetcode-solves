/**
 * Problem URL: https://leetcode.com/problems/climbing-stairs/description/
 * Level: Easy
 */
package dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ClimbingStairs.climbStairs(3));
        // Case 2
        System.out.println(ClimbingStairs.climbStairs(2));
    }

    public static int climbStairs(int n) {
        int first = 1, second = 2, current;
        if (n == 1) return 1;
        if (n == 2) return 2;
        for (int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }
        return second;
    }
}
