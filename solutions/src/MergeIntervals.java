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
        if (len == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        int[] cur, last;
        for (int i = 1; i < len; i++) {
            cur = intervals[i];
            last = result.getLast();
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                result.add(cur);
            }
        }

        return result.toArray(new int[0][0]);
    }
}
