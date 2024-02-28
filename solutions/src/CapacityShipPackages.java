/**
 * Problem URL: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description
 * Level: Medium
 */

public class CapacityShipPackages {

    public static void main(String[] args) {
        // Case 1
        System.out.println(CapacityShipPackages.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));

        // Case 2
        System.out.println(CapacityShipPackages.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));

        // Case 3
        System.out.println(CapacityShipPackages.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        if (n == 1)
            return weights[0];
        int lo = -1, hi = 0, mid;
        for (int weight : weights) {
            if (weight > lo)
                lo = weight;
            hi += weight;
        }
        if (n == days) return lo;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (canLoadWithGivenCapacity(weights, mid, days)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private static boolean canLoadWithGivenCapacity(int[] weights, int capacity, int totalDays) {
        int days = 1, sum = 0;
        for (int weight : weights) {
            if (weight > capacity)
                return false;
            if (sum + weight > capacity) {
                sum = weight;
                days++;
            } else {
                sum += weight;
            }
        }
        return days <= totalDays;
    }
}
