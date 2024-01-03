/**
 * Problem URL: https://leetcode.com/problems/climbing-stairs/description/
 * Level: Easy
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        // Case 1
        System.out.println(ClimbingStairs.climbStairs(3));
        // Case 2
        System.out.println(ClimbingStairs.climbStairs(2));
    }

    public static int climbStairs(int n) {
        int first = 1, sec = 2, cur = 0;
        if (n == 1)
            return first;
        if (n == 2)
            return sec;
        for (int i = 3; i <= n; i++) {
            cur = first + sec;
            first = sec;
            sec = cur;
        }
        return cur;
    }
}
