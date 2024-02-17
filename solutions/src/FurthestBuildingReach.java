/**
 * Problem URL: https://leetcode.com/problems/furthest-building-you-can-reach/
 * Level: Medium
 */

import java.util.PriorityQueue;

public class FurthestBuildingReach {

    public static void main(String[] args) {
        // Case 1
        System.out.println(FurthestBuildingReach.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));

        // Case 2
        System.out.println(FurthestBuildingReach.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));

        // Case 3
        System.out.println(FurthestBuildingReach.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
    }

    public static int furthestBuilding(int[] hts, int bricks, int ladders) {
        int n = hts.length;
        if (n == 1 || ladders == n)
            return n - 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int remain = 0, temp;
        for (int i = 1; i < n; i++) {
            if (hts[i] > hts[i - 1]) {
                heap.add(hts[i] - hts[i - 1]);
                if (heap.size() > ladders) {
                    temp = heap.poll();
                    remain += temp;
                    if (remain > bricks)
                        return i - 1;
                }
            }
        }
        return n - 1;
    }
}
