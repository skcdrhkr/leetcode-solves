package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(MergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));

        // Case 2
        System.out.println(Arrays.deepToString(MergeIntervals.merge(new int[][]{{1, 4}, {4, 5}})));

        // Case 3
        System.out.println(Arrays.deepToString(MergeIntervals.merge(new int[][]{{1, 4}, {2, 4}, {3, 6}, {8, 9}, {9, 12}})));

        // Case 4
        System.out.println(Arrays.deepToString(MergeIntervals.merge(new int[][]{{1, 5}, {4, 6}, {6, 8}, {11, 15}})));
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int idx=0;
        if(len<2) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        for(int i=1;i<len;i++) {
            if(intervals[idx][1]<intervals[i][0]) {
                idx+=1;
                intervals[idx][0]=intervals[i][0];
                intervals[idx][1]=intervals[i][1];
            } else {
                intervals[idx][1] = Math.max(intervals[idx][1],intervals[i][1]);
            }
        }
        return Arrays.copyOf(intervals,idx+1);
    }

    // Educative
    public static int[][] mergeIntervals(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();

        if (intervals.length == 0) {
            return new int[][]{};
        }

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] lastAddedInterval = result.getLast();
            int currStart = interval[0];
            int currEnd = interval[1];
            int prevEnd = lastAddedInterval[1];

            if (currStart <= prevEnd) {
                lastAddedInterval[1] = Math.max(currEnd, prevEnd);
            } else {
                result.add(new int[]{currStart, currEnd});
            }
        }

        return result.toArray(new int[][]{});
    }
}
