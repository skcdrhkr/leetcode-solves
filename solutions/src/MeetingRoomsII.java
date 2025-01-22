/**
 * Leetcode: https://leetcode.ca/all/253.html
 */

public class MeetingRoomsII {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MeetingRoomsII.minRooms(new int[][]{{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}}));

        // Case 2
        System.out.println(MeetingRoomsII.minRooms(new int[][]{{1, 3}, {2, 6}, {8, 10}, {9, 15}, {12, 14}}));

        // Case 3
        System.out.println(MeetingRoomsII.minRooms(new int[][]{{1, 2}, {4, 6}, {3, 4}, {7, 8}}));

        // Case 4
        System.out.println(MeetingRoomsII.minRooms(new int[][]{{1, 7}, {2, 6}, {3, 7}, {4, 8}, {5, 8}}));

        // Case 5
        System.out.println(MeetingRoomsII.minRooms(new int[][]{{0, 1000}, {0, 1000}, {1, 2}, {3, 10}, {5, 6}}));
    }

    public static int minRooms(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) return len;
        int[] times = new int[1000005];
        int mxTime = 0;
        for (int[] interval : intervals) {
            times[interval[0]]++;
            times[interval[1]]--;
            mxTime = Math.max(interval[1], Math.max(interval[0], mxTime));
        }
        int curRooms = times[0], minRooms = times[0];
        for (int i = 1; i < mxTime; i++) {
            curRooms += times[i];
            if (minRooms < curRooms) {
                minRooms = curRooms;
            }
        }
        return minRooms;
    }
}
