import java.util.Arrays;

public class PassengerPickup {

    public static void main(String[] args) {
        // Case 1
        System.out.println(PassengerPickup.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));

        // Case 2
        System.out.println(PassengerPickup.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));

        // Case 3
        System.out.println(PassengerPickup.carPooling(new int[][]{{9, 3, 4}, {9, 1, 7}, {4, 2, 4}, {7, 4, 5}}, 23));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int len = trips.length;
        int occupied;
        int[][] endSorted = new int[len][3];
        for (int i = 0; i < len; i++) {
            endSorted[i] = new int[]{trips[i][0], trips[i][1], trips[i][2]};
        }
        Arrays.sort(trips, (x, y) -> (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]));
        Arrays.sort(endSorted, (x, y) -> (x[2] != y[2] ? x[2] - y[2] : x[1] - y[1]));
        if (len < 2) {
            return capacity >= trips[0][0];
        }
        int left = 0, right = 1;
        if (capacity < trips[0][0]) return false;
        occupied = trips[0][0];
        for (int i = 1; i < len; i++) {
            while (left < i && trips[i][1] >= endSorted[left][2]) {
                occupied -= endSorted[left][0];
                left++;
            }
            occupied += trips[i][0];
            if (occupied > capacity) return false;
        }
        return true;
    }
}
