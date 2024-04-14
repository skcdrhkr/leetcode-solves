import java.util.Arrays;

public class MeetingRoomsII {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MeetingRoomsII.findSets(new int[][]{{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}}));

        // Case 2
        System.out.println(MeetingRoomsII.findSets(new int[][]{{1, 3}, {2, 6}, {8, 10}, {9, 15}, {12, 14}}));

        // Case 3
        System.out.println(MeetingRoomsII.findSets(new int[][]{{1, 2}, {4, 6}, {3, 4}, {7, 8}}));

        // Case 4
        System.out.println(MeetingRoomsII.findSets(new int[][]{{1, 7}, {2, 6}, {3, 7}, {4, 8}, {5, 8}}));

        // Case 5
        System.out.println(MeetingRoomsII.findSets(new int[][]{{0, 1000}, {0, 1000}, {1, 2}, {3, 10}, {5, 6}}));
    }

    public static int findSets(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) return len;
        Arrays.sort(intervals, (x, y) -> (x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]));
        int maxRooms = 1, curRooms = 1;
        int left = 0, right = 1;
        while (right < len) {
            if (intervals[right][0] < intervals[left][1]) {
                curRooms++;
            } else {
                while (left < right && intervals[left][1] <= intervals[right][0]) {
                    left++;
                    curRooms--;
                }
            }
            if (curRooms == 0) curRooms = 1;
            if (maxRooms < curRooms) maxRooms = curRooms;
            right++;
        }
        return maxRooms;
    }
}
