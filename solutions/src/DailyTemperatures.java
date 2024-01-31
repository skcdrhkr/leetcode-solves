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

    public static int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            if (temp[i + 1] > temp[i]) {
                res[i] = 1;
            } else {
                for (int k = i + 1; ; k = k + res[k]) {
                    if (temp[k] > temp[i]) {
                        res[i] = k - i;
                        break;
                    }
                    if (res[k] == 0) {
                        res[i] = 0;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
