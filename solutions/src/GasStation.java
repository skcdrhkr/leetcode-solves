/**
 * Problem URL: https://leetcode.com/problems/gas-station/description/
 * Level: Medium
 */

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        // Case 1
        System.out.println(GasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));

        // Case 2
        System.out.println(GasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));

        // Case 3
        System.out.println(GasStation.canCompleteCircuit(new int[]{7, 1, 0, 11, 4}, new int[]{5, 9, 1, 2, 5}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cur = 0;
        int gassum = Arrays.stream(gas).sum();
        int costsum = Arrays.stream(cost).sum();
        if (costsum > gassum) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            cur += gas[i];
            if (cur >= cost[i]) {
                cur -= cost[i];
            } else {
                res = (i + 1) % n;
                cur = 0;
            }
        }
        return res;
    }
}
