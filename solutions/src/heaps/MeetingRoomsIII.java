package heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII {

    public static void main(String[] args) {
        // Case 1
        System.out.println(MeetingRoomsIII.mostBooked(new int[][]{{0, 4}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 7}}, 4));

        // Case 2
        System.out.println(MeetingRoomsIII.mostBooked(new int[][]{{0, 10}, {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}}, 3));

        // Case 3
        System.out.println(MeetingRoomsIII.mostBooked(new int[][]{{0, 9}, {1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}, {7, 8}, {8, 9}}, 3));
    }

    public static int mostBooked(int[][] meetings, int rooms) {
        int[] booked = new int[rooms];
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < rooms; i++) freeRooms.add(i);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> (x[1] == y[1] ? x[2] - y[2] : x[1] - y[1]));
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));
        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= start) {
                freeRooms.add(minHeap.poll()[2]);
            }
            if (freeRooms.isEmpty()) {
                int[] firstEndMeet = minHeap.poll();
                end = firstEndMeet[1] + (end - start);
                freeRooms.add(firstEndMeet[2]);
            }
            int freeRoom = freeRooms.poll();
            minHeap.add(new int[]{start, end, freeRoom});
            booked[freeRoom]++;
        }

        int mxBooked = 0;
        for (int i = 1; i < rooms; i++) {
            if (booked[mxBooked] < booked[i]) {
                mxBooked = i;
            }
        }
        return mxBooked;
    }
}
