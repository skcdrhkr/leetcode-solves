import java.util.ArrayList;
import java.util.Arrays;

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
        int[] toAdd = newInterval;
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] val : intervals) {
            if (toAdd[1] < val[0]) {
                result.add(toAdd);
                toAdd = val;
                continue;
            } else if (toAdd[0] > val[1]) {
                result.add(val);
                continue;
            }
            if (toAdd[0] >= val[0]) {
                toAdd[0] = val[0];
            }
            if (toAdd[1] <= val[1]) {
                toAdd[1] = val[1];
            }
        }
        result.add(toAdd);
        return result.toArray(new int[result.size()][]);
    }
}
