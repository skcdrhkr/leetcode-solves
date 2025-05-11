package intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalListIntersections {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(IntervalListIntersections.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));

        // Case 2
        System.out.println(Arrays.deepToString(IntervalListIntersections.intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[][]{})));
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        int indexA = 0, indexB = 0;
        ArrayList<int[]> result = new ArrayList<>();
        while (indexA < n && indexB < m) {
            int newStart = Math.max(firstList[indexA][0], secondList[indexB][0]);
            int newEnd = Math.min(firstList[indexA][1], secondList[indexB][1]);
            if (newStart <= newEnd) {
                result.add(new int[]{newStart, newEnd});
            }
            if (firstList[indexA][1] < secondList[indexB][1]) indexA++;
            else indexB++;
        }
        return result.toArray(new int[0][]);
    }
}
