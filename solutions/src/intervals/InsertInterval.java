package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        // Case 1
        System.out.println(Arrays.deepToString(InsertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));

        // Case 2
        System.out.println(Arrays.deepToString(InsertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));

        // Case 3
        System.out.println(Arrays.deepToString(InsertInterval.insert(new int[][]{{1, 6}, {8, 9}, {10, 15}, {16, 18}}, new int[]{9, 10})));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cur[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = cur;
            } else if (newInterval[0] > cur[1]) {
                result.add(cur);
            } else {
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[0][]);
    }

    // Educative
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        int n = existingIntervals.length;
        List<int[]> outputList = new ArrayList<>();
        while (i < n && existingIntervals[i][0] < newStart) {
            outputList.add(existingIntervals[i]);
            i += 1;
        }
        if (outputList.size() == 0 || outputList.get(outputList.size() - 1)[1] < newStart) {
            outputList.add(newInterval);
        } else {
            outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], newEnd);
        }
        while (i < n) {
            int[] ei = existingIntervals[i];
            int start = ei[0];
            int end = ei[1];
            if (outputList.get(outputList.size() - 1)[1] < start) {
                outputList.add(ei);
            } else {
                outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], end);
            }
            i += 1;
        }
        return outputList.toArray(new int[0][0]);
    }
}
