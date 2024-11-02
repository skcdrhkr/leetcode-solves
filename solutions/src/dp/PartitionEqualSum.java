package dp;

import java.util.Arrays;

public class PartitionEqualSum {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PartitionEqualSum.canPartitionArray(new int[]{3, 1, 1, 2, 2, 1}));

        // Case 2
        System.out.println(PartitionEqualSum.canPartitionArray(new int[]{1, 3, 4, 8}));

        // Case 3
        System.out.println(PartitionEqualSum.canPartitionArray(new int[]{1, 3, 7, 3}));

    }

    public static boolean canPartitionArray(int[] arr) {
        int len = arr.length;
        int mx = Arrays.stream(arr).max().getAsInt();
        int[][] dp = new int[len + 1][mx * (len + 1)];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 20000; j++) {

            }
        }
        return false;
    }

    public static boolean canPartitionArrayTopDown(int[] arr) {
        // Replace this placeholder return statement with your code
        int[][] memo = new int[arr.length][20000];
        return getPartitionArray(arr, 0, 0, 0, memo);
    }

    private static boolean getPartitionArray(int[] arr, int ind, int sumA, int sumB, int[][] memo) {
        if (ind >= arr.length) {
            return sumA == sumB;
        }
        if (memo[ind][sumA] != 0) {
            return memo[ind][sumA] == 1;
        }
        boolean addInFirst = getPartitionArray(arr, ind + 1, sumA + arr[ind], sumB, memo);
        boolean addInSecond = getPartitionArray(arr, ind + 1, sumA, sumB + arr[ind], memo);
        memo[ind][sumA] = (addInSecond || addInFirst) ? 1 : 2;
        return addInSecond || addInFirst;
    }
}
