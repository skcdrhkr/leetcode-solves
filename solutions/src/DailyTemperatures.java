import java.util.Arrays;

/**
 * Problem URL: https://leetcode.com/problems/daily-temperatures/description/
 * Level: Medium
 */

public class DailyTemperatures {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.toString(DailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

        // Case 2
        System.out.println(Arrays.toString(DailyTemperatures.dailyTemperatures(new int[]{30, 40, 50, 60})));

        // Case 3
        System.out.println(Arrays.toString(DailyTemperatures.dailyTemperatures(new int[]{30, 60, 90})));
    }

    public static int[] dailyTemperatures(int[] temps) {
        int len = temps.length;
        int[] res = new int[len];
        if (len == 1) return res;
        int mxTillNow = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (temps[i] >= temps[mxTillNow]) {
                mxTillNow = i;
                continue;
            }
            int days = 1;
            while (temps[i + days] <= temps[i]) {
                days += res[i + days];
            }
            res[i] = days;
        }
        return res;
    }
}
